Feature: users tablosunun sutun isimlerini dogrula
  @US17TC01DB
  Scenario: TC-01 users tablosunun sutun isimlerini dogrula
    Given users tablosu icin Database bağlantısı kurulur
    And Expected users datalar duzenlenir
    When users tablosu sutun isimlerini almak icin query gonderilir
    Then users tablosu sutun isimleri dogrulanir
  #    | column_name           | data_type |
  #    | id                    | BIGINT    |
  #    | created_at            | TIMESTAMP |
  #    | updated_at            | TIMESTAMP |
  #    | built_in              | BOOLEAN   |
  #    | email                 | VARCHAR   |
  #    | enabled               | BOOLEAN   |
  #    | first_name            | VARCHAR   |
  #    | last_name             | VARCHAR   |
  #    | locked                | BOOLEAN   |
  #    | password_hash         | VARCHAR   |
  #    | phone                 | VARCHAR   |
  #    | reset_password_code   | VARCHAR   |
  #    | role                  | VARCHAR   |
  #    | picture_id            | BIGINT    |