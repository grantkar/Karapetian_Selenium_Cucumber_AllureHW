#language: ru

@All
  Функционал: Поиск на авито
    Сценарий: Найдем самые дорогие принтеры на авито
      Пусть Открыт ресурс авито
      И в выподающем списке категорий выбрана Оргтехника
      И в поле поиска введено значение "Принтер"
      Тогда кликнуть по выподающему списку региона
      Тогда в поле регион введено значение "Владивосток"
      И нажата кнопка показать объявления
      Тогда открылась страница результаты по запросу принтер
      И активирован чекбокс только с фотографией
      И в выподающем списке сортировка выбрано значение Дороже
      И в консоль выведено значение названия и цены 3 первых товаров
