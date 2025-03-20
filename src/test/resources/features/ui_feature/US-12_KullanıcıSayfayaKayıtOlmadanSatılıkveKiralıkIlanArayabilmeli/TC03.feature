@US-12
Feature:
  Scenario : Price Range bölümunde bulunan Min box alanina gecersiz bir data girildiginde uyari verilmeli (Negatif senaryo)
    Given Siteye gidilir.
    When Search kisminda bulunan arama butonuna tiklanir
    And Acilan pencerede Price Range, Advert Type, Category, Country, City, District bölümleri gorulur.
    And Price Range bolumunde bulunan Min box bolumune gecersiz bir data girilir.
    And Price Range bolumunde bulunan Max box bolumune gecerli bir data girilir.
    Then Search arama butonuna tiklandiginda uyari vermelidir.