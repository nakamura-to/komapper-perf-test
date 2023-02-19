# komapper-perf-test

Execute the following command:

```shell
$ ./gradlew benchmark
```

You will see the following results:

Exposed:
```
main summary:
Benchmark                        Mode  Cnt      Score       Error  Units
ExposedBenchmark.insert_entity  thrpt    3  35567.937 ±  3353.034  ops/s
ExposedBenchmark.insert_sql     thrpt    3  65843.903 ± 15326.269  ops/s
```

Komapper:
```
main summary:
Benchmark                         Mode  Cnt      Score       Error  Units
KomapperBenchmark.insert_entity  thrpt    3  70601.455 ± 36951.686  ops/s
KomapperBenchmark.insert_sql     thrpt    3  68904.376 ±  5665.886  ops/s
```

Ktorm:
```
main summary:
Benchmark                      Mode  Cnt      Score      Error  Units
KtormBenchmark.insert_entity  thrpt    3  53404.139 ± 5903.319  ops/s
KtormBenchmark.insert_sql     thrpt    3  59394.098 ± 3615.305  ops/s
```