@US-17
@UI
@Manager
Feature: US-17_ManagerCreatReport test

  Scenario: Tur isteklerine gore rapor olusturabilmelidir
    Given Manager olarak profil butonuna tiklanir
    And Mnager olarak kontrol paneline tiklanir
    And Manager olarak Raporlar sayfasina gidilir
    And Manager olarak Start date kismina gecerli bir veri girilir
    And Manager olarak End date kismina gecerli bir veri girlir
    And Manager olarak Status kismi secilir
    And Manager olarak Rapordort Olustur butonuna tiklanir
    Then Manager olarak Tur istekleri listelenir ve rapor basariyla olusturulur
    And Sayfa kapatilir







