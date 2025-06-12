public record ExchangerateApi(
                              String result,
                              String base_code,
                              String target_code,
                              ConversionRates conversion_rates,
                              Double conversion_result
                            ) { }
