package io.github.wistefan.cosmos

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.fiware.cosmos.orion.spark.connector.OrionReceiver
import org.slf4j.LoggerFactory

object ExampleReceiver {

  def main(args: Array[String]): Unit = {
    println("Started v2 receiver")

    val sparkConf = new SparkConf().setAppName("ExampleReceiver")
    val ssc = new StreamingContext(sparkConf, Seconds(10))

    val eventStream = ssc.receiverStream(new OrionReceiver(9001))
    eventStream.flatMap(e => e.entities).print()

    ssc.start()
    ssc.awaitTermination()
  }
}
