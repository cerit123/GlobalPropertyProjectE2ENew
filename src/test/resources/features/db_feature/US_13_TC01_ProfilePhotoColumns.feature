Feature: profile_photos tablosunun sutun isimlerini dogrula

  @US13TC01DB
  Scenario: TC-01 profile_photos tablosunun sutun isimlerini dogrula
    Given Profile_photos tablosunu icin Database bağlantısı kurulur
    And Expected profile_photos data lar duzenlenir
    When profile_photos tablosu sutun isimlerini almak icin query gonderilir
    Then profile_photos tablosu sutun isimleri dogrulanir
  #    | column_name | type         |
  #    | id          | image/jpeg   |
  #    | data        | image/jpeg   |
  #    | name        | image/jpeg   |
  #    | type        | image/jpeg   |
