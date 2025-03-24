Feature: Counries Controller Api test
  Scenario: Get  ile tum sehirleri getirme
    Given  Get icin Base URL kullanilir
    When Tum sehirleri getirir
    Then Staus code 200 olmalidir
    And Tum sehirleri alindigi dogrulanir