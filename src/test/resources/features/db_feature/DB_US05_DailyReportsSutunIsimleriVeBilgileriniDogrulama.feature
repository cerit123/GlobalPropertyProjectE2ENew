@US05DB
Feature: Daily Reports Sutun isimlerini ve bilgilerini dogrulama

  Scenario: TC-01 Daily Reports Sutun isimlerini dogrulama
    Given Database bağlantısı sağlanır
    When Beklenen sutun isimleri düzenlenir
    And Sutun isimlerini almak için query gönderilir
    Then Sutun isimleri dogrulanır

  Scenario: TC-02 Daily Reports Sutun bilgilerini dogrulama
    Given Database bağlantısı sağlanır
    When Beklenen sutun isimleri düzenlenir
    And 10-11 id numarali Sutun isimlerini almak için query gönderilir
    Then 10-11 id numarali kayitlarin oldugu dogrulanir