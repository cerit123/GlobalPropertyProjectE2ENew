@US-19 @Costumer
Feature:Kullanicilar sayfadan mesaj gonderebilmelidir
  Scenario: Kullanici mesaj gonderebilmelidir

    Given Kullanici sayfaya gider
    When  Contact sekmesi tiklanir
    And   Acilan pencereye gecerli bir first name girilir
    And   Acilan pencereye gecerli bir last name girilir
    And   Gecerli bir email adresi girilir
    And   Acilan pencereye gecerli bir mesaj girilir
    And   Send butonuna tiklanir
    Then  Mesaj gonderildigini dogrular
