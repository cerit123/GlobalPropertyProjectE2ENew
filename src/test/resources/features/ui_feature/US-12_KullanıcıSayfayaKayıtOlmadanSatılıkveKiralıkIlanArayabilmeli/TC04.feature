@US-12
Feature:
  Scenario : Seçtiği emlak ile alakalı resim, Description, DETAILS, LOCATION bilgilerini görebilmeli.
    Given Siteye gidilir.
    When Search kisminda bulunan arama butonuna tiklanir
    And Acilan pencerede Price Range, Advert Type, Category, Country, City, District bölümleri gorulur.
    And Acilan pencerede bir emlak secilir.
    Then Seçilen emlak ile alakalı resim, Description, DETAILS, LOCATION bilgilerinin gorulebildigi dogrulanir.