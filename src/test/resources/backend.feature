Feature: Scenarios for CoinMarketCap frontend tests

  Scenario: Back-end Task 1
    Given user calls /cryptocurrency/map service
    When the status code is 200
    Then user convert them to Bolivian Boliviano using the /tools/price-conversion call


#  1. Retrieve the ID of bitcoin (BTC), usd tether (USDT), and Ethereum (ETH), using the
#  /cryptocurrency/map call.
#  2. Once you have retrieved the IDs of these currencies, convert them to Bolivian Boliviano,
#  using the /tools/price-conversion call.

    Scenario: Back-end Task 2
      Given user placed /cryptocurrency/info call by Ethereum ID 1027
      When user gets response
      Then response includes the following
      | data.1027.logo                  | https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png |
      | data.1027.urls.technical_doc[0] | https://github.com/ethereum/wiki/wiki/White-Paper            |
      | data.1027.symbol                | ETH                                                          |
      | data.1027.date_added            | 2015-08-07T00:00:00.000Z                                     |
      | data.1027.platform              |null                                                          |
      | data.1027.tags[0]               | mineable                                                     |

#    1. Retrieve the Ethereum (ID 1027) technical documentation website from the
#    cryptocurrency/info call.
#    2. Confirm that the following logo URL is present:
#    "logo":
#    https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png.
#    3. Confirm that the technical_doc URl is present:
#    "technical_doc": [
#    https://github.com/ethereum/wiki/wiki/White-Paper
#    ]
#    4. Confirm that the symbol of the currency is ETH:
#    "symbol": "ETH"
#    5. Confirm that the date added is:
#    "date_added": "2015-08-07T00:00:00.000Z"
#    6. Confirm that the platform is null:
#    "platform": null,
#    7. Confirm that the currency has the mineable tag associated with it:
#    "tags": [
#    "mineable"
#    ]

      Scenario: Back-end Task 3 (Extra Points)
#      1. Retrieve the first 10 currencies from the cryptocurrency/info call (ID 1, 2, 3 … 10).
#      2. Check which currencies have the mineable tag associated with them.
#      3. Verify that the correct cryptocurrencies have been printed out.
