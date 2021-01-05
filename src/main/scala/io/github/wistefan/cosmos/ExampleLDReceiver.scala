package io.github.wistefan.cosmos

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.fiware.cosmos.orion.spark.connector.{NGSILDReceiver, OrionReceiver, OrionSinkObject}

object ExampleLDReceiver {

  def main(args: Array[String]): Unit = {
    println("Started ld receiver")
    val sparkConf = new SparkConf().setAppName("ExampleLDReceiver")
    val ssc = new StreamingContext(sparkConf, Seconds(1000))

    val eventStream = ssc.receiverStream(new NGSILDReceiver(9001))
    eventStream.flatMap(e => e.entities).print()

    ssc.start()
    ssc.awaitTermination()
  }
}
