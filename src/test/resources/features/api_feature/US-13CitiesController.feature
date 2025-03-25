@API
@apiAdmin
Feature: City-Controller
  @US-13
  Scenario:TC01 Kullanıcı Şehir Kontrolü Testi
    Given Kullanıcı için GET URL oluşturulur
    And   kullanıcı için GET isteği gönderilir ve yanıt alınır
    Then Staus code 200 olmalidir
    Then yanıt gövdesinin kullanıcı için doğru olduğu doğrulanır
