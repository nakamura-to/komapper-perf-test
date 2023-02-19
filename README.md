# komapper-perf-test

Execute the following command:

```shell
$ ./gradlew benchmark
```

You will see the following results:

Exposed:
```
main summary:
Benchmark                        Mode  Cnt      Score      Error  Units
ExposedBenchmark.insert_entity  thrpt    3  35497.130 ± 5485.228  ops/s
ExposedBenchmark.insert_sql     thrpt    3  64542.461 ± 4812.642  ops/s
```

Komapper:
```
main summary:
Benchmark                         Mode  Cnt      Score       Error  Units
KomapperBenchmark.insert_entity  thrpt    3  65632.297 ± 22440.282  ops/s
KomapperBenchmark.insert_sql     thrpt    3  72596.164 ± 17024.784  ops/s
```

Ktorm:
```
main summary:
Benchmark                      Mode  Cnt      Score      Error  Units
KtormBenchmark.insert_entity  thrpt    3  53958.314 ± 3064.975  ops/s
KtormBenchmark.insert_sql     thrpt    3  76468.507 ± 1464.332  ops/s
```