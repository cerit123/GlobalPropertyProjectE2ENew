@US-15üc
@UI
@Admin
Feature: Admin Kullanıcı Arama

  Scenario: Admin kullanıcı arar
  //  Given Siteye gidilir
  //  When Log in butonuna tıklanılır
  //  And Admin bilgileri girilir
    And Kullanıcılar sekmesine tıklanılır
    And Search kutusuna aranan kullanıcı adı girilir
    And Search butonuna tıklanır
    Then Girilen kullanıcı adının arama sonuçlarında görüntülendiği doğrulanır
