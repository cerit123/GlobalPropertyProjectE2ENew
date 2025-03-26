Feature: users tablosunun sutun isimlerini dogrula
  @US17TC02DB
  Scenario: TC-01 users tablosunun sutun bilgilerini dogrula
    Given users tablosu icin Database bağlantısı kurulur
    And Expected users datalar duzenlenir
    When users tablosu sutun bilgileri sorgulanır
    Then users tablosu sutun bilgileri dogrulanir