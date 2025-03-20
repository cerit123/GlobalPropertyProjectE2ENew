@US20 @Manager @UI @E2E
Feature: Manager deletes contact messages

  Scenario: Manager Contact mesajları görebilmeli ve silebilmelidir

    Given  Contact mesajları sayfasına gidilir
    When Mesajlar görüntülenir
    And Bir mesaj silinir
    Then Mesajin silindigi dogrulanir

