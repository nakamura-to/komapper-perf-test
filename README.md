# komapper-perf-test

Execute the following command:

```shell
$ ./gradlew benchmark
```

You will see the following results:

```
main summary:
Benchmark                        Mode  Cnt      Score       Error  Units
ExposedBenchmark.insert_entity  thrpt    5  27528.294 ± 13412.416  ops/s
ExposedBenchmark.insert_sql     thrpt    5  54747.811 ± 10635.907  ops/s
```

```
main summary:
Benchmark                         Mode  Cnt      Score       Error  Units
KomapperBenchmark.insert_entity  thrpt    5  58407.249 ± 27574.676  ops/s
KomapperBenchmark.insert_sql     thrpt    5  64247.526 ±  3418.063  ops/s

```