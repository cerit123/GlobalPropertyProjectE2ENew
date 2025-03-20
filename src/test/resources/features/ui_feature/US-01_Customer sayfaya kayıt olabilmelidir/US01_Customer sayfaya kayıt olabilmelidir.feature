@UI
@E2E
@US01

Feature: US01 Customer sayfaya kayıt olabilmelidir.

  @US01TC01
  Scenario: TC01 Geçerli datalar ile kullanıcı kayıt olabilir
    Given sayfaya gidilir
    When Register sekmesine tiklanir
    And First name kısmına "Muhammet" girilir
    And Last name kısmına "Olunk" girilir
    And Phone number kısmına "5429592497" girilir
    And Email address kısmına "samle36@gmail.com" girilir
    And Password kısmına "12345aA?" yazılır
    And Confirm password kısmına "12345aA?" tekrar yazılır
    And Terms of Use butonuna tıklanır
    And Register butonuna tıklanır
    Then Kayıt işlemi doğrulanır


  @US01TC02
  Scenario: TC02 First Name boş geçildiğinde kayıt işlemi başarısız olmalıdır
    Given sayfaya gidilir
    When Register sekmesine tiklanir
    And First name kısmına "" girilir
    And Last name kısmına "Olunk" girilir
    And Phone number kısmına "5447797197" girilir
    And Email address kısmına "sampl661e@gmail.com" girilir
    And Password kısmına "12345aA?" yazılır
    And Confirm password kısmına "12345aA?" tekrar yazılır
    And Terms of Use butonuna tıklanır
    And Register butonuna tıklanır
    Then Kayıt işleminin başarısız olduğu doğrulanır


  @US01TC03
  Scenario: TC03 Last Name boş geçildiğinde kayıt işlemi başarısız olmalıdır
    Given sayfaya gidilir
    When Register sekmesine tiklanir
    And First name kısmına "Muhammet" girilir
    And Last name kısmına "" girilir
    And Phone number kısmına "5447797197" girilir
    And Email address kısmına "sampl661e@gmail.com" girilir
    And Password kısmına "12345aA?" yazılır
    And Confirm password kısmına "12345aA?" tekrar yazılır
    And Terms of Use butonuna tıklanır
    And Register butonuna tıklanır
    Then Kayıt işleminin başarısız olduğu doğrulanır


  @US01TC04
  Scenario: TC04 Phone Number boş geçildiğinde kayıt işlemi başarısız olmalıdır
    Given sayfaya gidilir
    When Register sekmesine tiklanir
    And First name kısmına "Muhammet" girilir
    And Last name kısmına "Olunk" girilir
    And Phone number kısmına "" girilir
    And Email address kısmına "sampl661e@gmail.com" girilir
    And Password kısmına "12345aA?" yazılır
    And Confirm password kısmına "12345aA?" tekrar yazılır
    And Terms of Use butonuna tıklanır
    And Register butonuna tıklanır
    Then Kayıt işleminin başarısız olduğu doğrulanır


  @US01TC05
  Scenario: TC05 E-mail boş geçildiğinde kayıt işlemi başarısız olmalıdır
    Given sayfaya gidilir
    When Register sekmesine tiklanir
    And First name kısmına "Muhammet" girilir
    And Last name kısmına "Olunk" girilir
    And Phone number kısmına "5447797197" girilir
    And Email address kısmına "" girilir
    And Password kısmına "12345aA?" yazılır
    And Confirm password kısmına "12345aA?" tekrar yazılır
    And Terms of Use butonuna tıklanır
    And Register butonuna tıklanır
    Then Kayıt işleminin başarısız olduğu doğrulanır


  @US01TC06
  Scenario: TC06 Password boş geçildiğinde kayıt işlemi başarısız olmalıdır
    Given sayfaya gidilir
    When Register sekmesine tiklanir
    And First name kısmına "Muhammet" girilir
    And Last name kısmına "Olunk" girilir
    And Phone number kısmına "5447797197" girilir
    And Email address kısmına "sampl661e@gmail.com" girilir
    And Password kısmına "" yazılır
    And Confirm password kısmına "" tekrar yazılır
    And Terms of Use butonuna tıklanır
    And Register butonuna tıklanır
    Then Kayıt işleminin başarısız olduğu doğrulanır


  @US01TC07
  Scenario: TC07 Terms of Use kutusu işaretlenmediğinde kayıt işlemiş başarısız olmalı
    Given sayfaya gidilir
    When Register sekmesine tiklanir
    And First name kısmına "Muhammet" girilir
    And Last name kısmına "Olunk" girilir
    And Phone number kısmına "5447797197" girilir
    And Email address kısmına "sampl661e@gmail.com" girilir
    And Password kısmına "12345aA?" yazılır
    And Confirm password kısmına "12345aA?" tekrar yazılır
    And Terms of Use butonuna tıklanmaz
    And Register butonuna tıklanır
    Then Kayıt işleminin başarısız olduğu doğrulanır


  @US01TC08
  Scenario: TC08 (@) Sembol olmadan email girildiğinde Invalid email hatası görünmelidir
    Given sayfaya gidilir
    When Register sekmesine tiklanir
    And First name kısmına "Muhammet" girilir
    And Last name kısmına "Olunk" girilir
    And Phone number kısmına "5447797197" girilir
    And Email address kısmına "sampl661egmail.com" girilir
    And Password kısmına "12345aA?" yazılır
    And Confirm password kısmına "12345aA?" tekrar yazılır
    And Terms of Use butonuna tıklanır
    And Register butonuna tıklanır
    Then Kayıt işleminin başarısız olduğu doğrulanır


  @US01TC09
  Scenario: TC09 (.) Sembol olmadan email girildiğinde Invalid email hatası görünmelidir
    Given sayfaya gidilir
    When Register sekmesine tiklanir
    And First name kısmına "Muhammet" girilir
    And Last name kısmına "Olunk" girilir
    And Phone number kısmına "5447797197" girilir
    And Email address kısmına "sampl661e@gmailcom" girilir
    And Password kısmına "12345aA?" yazılır
    And Confirm password kısmına "12345aA?" tekrar yazılır
    And Terms of Use butonuna tıklanır
    And Register butonuna tıklanır
    Then Kayıt işleminin başarısız olduğu doğrulanır


  @US01TC10
  Scenario: TC10 Password 8 karakterden az olduğunda kayıt işlemi başarısız olmalıdır
    Given sayfaya gidilir
    When Register sekmesine tiklanir
    And First name kısmına "Muhammet" girilir
    And Last name kısmına "Olunk" girilir
    And Phone number kısmına "5447797197" girilir
    And Email address kısmına "sampl661e@gmailcom" girilir
    And Password kısmına "1234aA?" yazılır
    And Confirm password kısmına "1234aA?" tekrar yazılır
    And Terms of Use butonuna tıklanır
    And Register butonuna tıklanır
    Then Kayıt işleminin başarısız olduğu doğrulanır


  @US01TC11
  Scenario: TC11 Password sadece harflerden oluştuğunda kayıt işlemi başarısız olmalıdır
    Given sayfaya gidilir
    When Register sekmesine tiklanir
    And First name kısmına "Muhammet" girilir
    And Last name kısmına "Olunk" girilir
    And Phone number kısmına "5447797197" girilir
    And Email address kısmına "sampl661e@gmailcom" girilir
    And Password kısmına "abcdefgh" yazılır
    And Confirm password kısmına "abcdefgh" tekrar yazılır
    And Terms of Use butonuna tıklanır
    And Register butonuna tıklanır
    Then Kayıt işleminin başarısız olduğu doğrulanır


  @US01TC12
  Scenario: TC12 Password sadece rakamlardan oluştuğunda kayıt işlemi başarısız olmalıdır
    Given sayfaya gidilir
    When Register sekmesine tiklanir
    And First name kısmına "Muhammet" girilir
    And Last name kısmına "Olunk" girilir
    And Phone number kısmına "5447797197" girilir
    And Email address kısmına "sampl661e@gmailcom" girilir
    And Password kısmına "12345678" yazılır
    And Confirm password kısmına "12345678" tekrar yazılır
    And Terms of Use butonuna tıklanır
    And Register butonuna tıklanır
    Then Kayıt işleminin başarısız olduğu doğrulanır


  @US01TC13
  Scenario: TC13 Phone Number eksik girildiğinde kayıt işlemi başarısız olmalı
    Given sayfaya gidilir
    When Register sekmesine tiklanir
    And First name kısmına "Muhammet" girilir
    And Last name kısmına "Olunk" girilir
    And Phone number kısmına "544779719" girilir
    And Email address kısmına "sampl661e@gmailcom" girilir
    And Password kısmına "12345aA?" yazılır
    And Confirm password kısmına "12345aA?" tekrar yazılır
    And Terms of Use butonuna tıklanır
    And Register butonuna tıklanır
    Then Kayıt işleminin başarısız olduğu doğrulanır





