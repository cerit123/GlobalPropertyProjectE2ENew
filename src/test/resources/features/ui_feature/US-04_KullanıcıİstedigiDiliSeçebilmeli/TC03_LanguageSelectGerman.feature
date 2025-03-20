@US-04 @UI
Feature:US-04_Kullanıcı (Admin, Manager, Customer)  5 farkli dilde sayfayı görüntüleyebilmelidir.

  Scenario:Kullanıcı (Admin, Manager, Customer)  5 farkli dilde sayfayı görüntüleyebilmelidir.
    Given Dil seçme sekmesine tıklanır.
    When  İstenilen dil Almanca seçilmelidir.
    Then  İstenilen dil seçilebilir olmalıdır.