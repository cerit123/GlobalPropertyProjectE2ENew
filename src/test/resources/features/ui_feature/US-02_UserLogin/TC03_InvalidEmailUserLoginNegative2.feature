@US2 @UI @E2E
Feature: US2_UserLogin Test
  Scenario: (.) Sembol olmadan email girildiğinde Invalid email hatası görünmelidir

    Given Sayfaya gidilir
    When Login sekmesine tiklanir
    And Email adresi . sembolu olmadan girilir
    And Kullanici passwordu girilir
    And Login butonuna tiklanir
    Then Invalid email uyarisi geldigi dogrulanir









