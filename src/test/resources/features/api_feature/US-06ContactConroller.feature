@API

Feature: Contact Massage Management

  @apiAdmin
  Scenario:Yeni bir iletisim mesaji olusturulabilmeli
    Given Base URL kullanilir
    When Yeni bir iletisim mesaji  olusturulur
    Then Staus code 200 olmalidir
    And Yeni bir iletisim mesaji olusturuldigi dogrulanir

  @apiAdmin
  Scenario:Tum mesajlardan ilki iletisim mesaji olusturulabilmeli
    Given Base URL kullanilir
    When Tum mesajlardan ilki iletisim mesaji getirilir
    Then Staus code 200 olmalidir
    And Yeni bir iletisim mesaji alindigi dogrulanir
  @apiAdmin
  Scenario:Belirli bir iletişim mesajının alınabileceğini doğrulayın
    Given Base URL kullanilir
    When Belirli bir iletisim mesaji  ID göre alın
    Then Staus code 200 olmalidir
    And Ve seçilen mesaj ayrıntılarını doğrulayın

