import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Write_JSON_Simple {
    public static void main(String[] args) throws IOException {

        // Tạo ra dòng ghi dữ liệu(Writer)
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("employee.json"));

        //Tạo đối tượng là
        JsonObject employee = new JsonObject();
        employee.put("id",1);
        employee.put("name","Quach Dang Diep");
        employee.put("email","Diep@gmail.com");
        employee.put("age",18);
//        employee.put("address", "So 8 Ton That Thuyet");

        //Tạo ra đối tuọng Address
        JsonObject address = new JsonObject();
        address.put("Street","So 8 Ton That Thuyet");
        address.put("City", "HaNoi");
        address.put("Zipcode",10000);

        //Thêm Address vào Object employee
        employee.put("address", address);

        //Tạo đối tượng project
        JsonArray projects = new JsonArray();//1-N(employee - project)

        //Tạo đối tượng dự án 1
        JsonObject pro1 = new JsonObject();
        pro1.put("title", "Employee managament");
        pro1.put("budget", 50000);

        //Thêm Project
        JsonObject pro2 = new JsonObject();
        pro2.put("title", "push sale");
        pro2.put("budget", 10000);

        JsonObject pro3 = new JsonObject();
        pro3.put("title", "Shop ecommerce");
        pro3.put("budget", 150000);

        //Add pro1,2 to project
        projects.addAll(Arrays.asList(pro1,pro2,pro3));

        //Add project to employee
        employee.put("projects", projects);

        //Ghi file Json
        Jsoner.serialize(employee,writer);//ghi ra file Json thong tin cua employee
        //sau khi ghi xong close dong writer
        writer.close();
    }
}
