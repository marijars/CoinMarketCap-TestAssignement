Feature: Scenarios for CoinMarketCap frontend tests
  Background:
    Given user opened Home page

  Scenario: Test 1
    When user switches display of cryptocurrencies to View All
    Then 100 cryptocurrencies are displayed in the list

  Scenario: Test 2
    When user adds between 5 and 10 random cryptocurrencies to watchlist
    And opens the watchlist in new browser tab
    Then selected cryptocurrencies are displayed in the watchlist tab

  Scenario Outline: Test 3
    When user selects full list option for cryptocurrencies <group>
    And user applies filters with <market cap>, <price> and <volume>
    Then cryptocurrencies that match the filters are displayed
    Examples:
      | group                 | market cap                 | price     | volume       |
      | All Cryptocurrencies  | $1 Million - $10 Million   | $1 - $100 | All          |
      | Coins Only            | All                        | $100+     | $10 Million+ |
      | Tokens Only           | $10 Million - $100 Million | All       | $10k+        |

