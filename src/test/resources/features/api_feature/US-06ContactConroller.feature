@API
@apiAdmin
  @US-06
Feature: Contact Massage Management

  @US-06
  Scenario:Yeni bir iletisim mesaji olusturulabilmeli
    Given Base URL kullanilir
    When Yeni bir iletisim mesaji  olusturulur
    Then Staus code 200 olmalidir
    And Yeni bir iletisim mesaji olusturuldigi dogrulanir

  @US-06
  Scenario:Tum mesajlardan ilki iletisim mesaji olusturulabilmeli
    Given Base URL kullanilir
    When Tum mesajlardan ilki iletisim mesaji getirilir
    Then Staus code 200 olmalidir
    And Yeni bir iletisim mesaji alindigi dogrulanir
  @US-06
  Scenario:Belirli bir iletişim mesajının alınabileceğini doğrulayın
    Given Base URL kullanilir
    When Belirli bir iletisim mesaji ID göre alın
    Then Staus code 200 olmalidir
    And Ve seçilen mesaj ayrıntılarını doğrulayın
  @US-06
    Scenario:Belirli bir iletisim mesaji guncellenebilmelidir
    Given Base URL kullanilir
    When Belirli bir iletisim mesaji guncellenir
    Then Staus code 200 olmalidir
    And Ve seçilen mesaj ayrıntılarını doğrulayın
  @US-06
    Scenario: Belirli bir iletisim mesaji silinebilmelidir
      Given Belirli bir mesaj silinir
      Then Staus code 200 olmalidir
      And Mesajin silindigi dogrulanir

