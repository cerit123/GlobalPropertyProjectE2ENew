@API

Feature: Contact Massage Management
  @ApiCustomer
  Scenario:Yeni bir iletisim mesaji olusturulabilmeli
    Given Base URL kullanilir
    When Yeni bir iletisim mesaji "merhaba hayat" olarak olusturulur
    Then Staus code 200 olmalidir
    And Yeni bir iletisim mesaji olusturuldigi dogrulanir