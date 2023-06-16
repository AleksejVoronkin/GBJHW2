// Задание

// 1) Дана строка sql-запроса "select * from students WHERE ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// String input_str = "{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}"
// Ввод данных: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// вывод: select * from students WHERE name=Ivanov AND country=Russia AND city=Moscow

package JAVA;
import java.util.HashMap;
import java.util.Map;

public class J4 {
    public static void main (String[] args){ 
String input_str = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
Map<String, String> params = new HashMap<>();
    params.put("name", "");
    params.put("country", "");
    params.put("city", "");
    params.put("age", "");

for (String param : input_str.split(",")) {
    String[] keyValue = param.split(":");
    String key = keyValue[0].replaceAll("[\\p{P}]", "");
    String value = keyValue[1].replaceAll("[\\p{P}]", "");
        if (!value.equalsIgnoreCase("null")) {
         params.put(key, value);
        }
    }

StringBuilder Where = new StringBuilder();
for (String key : params.keySet()) {
    if (!params.get(key).isEmpty()) {
        Where.append(key).append(" = ").append(params.get(key)).append(" AND");
    }
    }

Where.delete(Where.length() - 5, Where.length());
System.out.println("select * from students WHERE " + Where);
    }
}

