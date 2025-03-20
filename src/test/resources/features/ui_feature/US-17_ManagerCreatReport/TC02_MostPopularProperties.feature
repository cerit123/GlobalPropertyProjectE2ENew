@US-17
@UI
@Manager
Feature: US-17_ManagerCreatReport test

  Scenario:Eksik bilgi ile rapor olusturma yapildiginda hata mesaji almalidir

    Given Manager olarak profil butonuna tiklanir
    When Mnager olarak kontrol paneline tiklanir
    And Manager olarak Raporlar sayfasina gidilir
    And  start date kismina  bos birakilir
    And end date kismina gecerli veri girilir
    And category kismi house olarak secilir
    And advert type kismini rent olarak secilir
    And Manager olarak Status kismi  pending olaraksecilir
    And Manager olarak rapor Olusturulur
    Then Manager olarak Raporun basariyla olusturulmadigi ve hata mesaji alindigi gorulur
    And Sayfa kapatilir







