FROM  bitnami/spark:3.0.1-debian-10-r115

ENV MASTER_URL=spark://localhost:7077
ENV CLASS=io.github.wistefan.cosmos.ExampleLDReceiver

RUN mkdir /opt/application
COPY target/cosmos-spark-example-0.0.1-SNAPSHOT.jar /opt/application/app.jar

CMD /opt/bitnami/spark/bin/spark-submit --class $CLASS --master $MASTER_URL --deploy-mode client /opt/application/app.jar --conf "spark.driver.extraJavaOptions=-Dlog4jspark.root.logger=WARN,console"