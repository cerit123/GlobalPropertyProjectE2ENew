@US-12
Feature:
  Scenario : Price Range, Advert Type, Category, Country, City, District bölümlerini girerek özel arama yapabilmeli.
    Given Siteye gidilir.
    When Search kisminda bulunan arama butonuna tiklanir
    And Acilan pencerede Price Range, Advert Type, Category, Country, City, District bölümleri gorulur.
    And Price Range bolumunde bulunan Min box bolumune gecerli bir data girilir.
    And Price Range bolumunde bulunan Max box bolumune gecerli bir data girilir.
    Then Price Range bolumunde bulunan Min box ve Max box bolumlerine gecerli bir data girilebildigi dogrulanir.