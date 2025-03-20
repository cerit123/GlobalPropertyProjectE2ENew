@US-16
@UI
@Admin
Feature:  US-16_AdminCreatReport test

  Scenario: Kullanici bilgilerine gore rapor olusturabilmelidir
    Given Manager olarak profil butonuna tiklanir
    And Mnager olarak kontrol paneline tiklanir
    And Rapor butonuna tiklanir
    When Kullanicilar kismi Admin olarak secilir
    And Raporu Olustur butonuna tiklanir
    Then Admin kullanici bilgisiyle raporun olusturuldugu  gorulur
    And logout butonuna tiklanir
    And Sayfa kapatilir



