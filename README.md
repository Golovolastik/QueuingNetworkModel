# Моделирование системы массового обслуживания (СМО)

## Описание проекта
Проект направлен на разработку алгоритма и программной имитационной модели системы массового обслуживания (СМО) для оценки ключевых характеристик:

- **Ротк** – вероятность отказа;
- **Рбл** – вероятность блокировки;
- **Lоч** – средняя длина очереди;
- **Q** – относительная пропускная способность;
- **А** – абсолютная пропускная способность.

Программа осуществляет сбор и статистическую обработку данных для получения численных оценок указанных параметров.

## Структура проекта  
project/  
├── src/ # Исходный код программы  
├── pom.xml # Конфигурация Maven  
└── README.md # Этот файл  

![Схема СМО](https://i.imgur.com/xyz123.png)