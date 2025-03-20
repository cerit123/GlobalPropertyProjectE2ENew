
@US-15bir
@UI
@Admin
Feature: US-15_Administrator Actions test


  Scenario: Admin yeni bir kategori oluşturur
    //Given Siteye gidilir
    //When Log in butonuna tıklanılır
    //And Admin bilgileri girilir
    And Kategori sekmesine tıklanılır
    And Add New butonuna tıklanır
    And Kategori başlık, sıra nosu, ikon ismi girilir
    And Oluştur butonuna tıklanılır
    Then Kategori başarıyla oluşturuldu mesajı görüntülenmelidir
