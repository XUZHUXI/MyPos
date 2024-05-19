package models;

import java.util.TreeMap;

public class ReadCategoryProduct {
    
     //準備好產品清單  
    public static TreeMap<String, Product> readProduct() {
        //read_product_from_file(); //從檔案或資料庫讀入產品菜單資訊
        //放所有產品  產品編號  產品物件
        TreeMap<String, Product> product_dict = new TreeMap<>();
        String[][] product_array = {
            {"p-j-101", "熱炒類", "三杯雞", "150", "1.1.png", "產品描述"},
            {"p-j-102", "熱炒類", "麻油松阪豬", "150", "1.2.png", "產品描述"},
            {"p-j-103", "熱炒類", "麻婆豆腐", "150", "1.3.png", "產品描述"},
            {"p-j-104", "熱炒類", "五更腸旺", "150", "1.4.png", "產品描述"},
            {"p-j-105", "熱炒類", "蒜泥白肉", "150", "1.5.png", "產品描述"},
            {"p-j-106", "熱炒類", "蔥爆牛肉", "150", "1.6.png", "產品描述"},
            {"p-j-107", "熱炒類", "三杯中卷", "150", "1.7.png", "產品描述"},
            {"p-j-108", "青菜類", "炒空心菜", "100", "2.1.png", "產品描述"},
            {"p-j-109", "青菜類", "炒水蓮", "100", "2.2.png", "產品描述"},
            {"p-j-110", "青菜類", "炒高麗菜", "100", "2.3.png", "產品描述"},
            {"p-j-111", "酥炸類", "蚵仔酥", "120", "3.1.png", "產品描述"},
            {"p-j-112", "酥炸類", "水晶魚", "100", "3.2.png", "產品描述"},
            {"p-j-113", "酥炸類", "鳳梨蝦球", "100", "3.3.png", "產品描述"},
            {"p-j-114", "湯類", "蛤仔湯", "100", "4.1.png", "產品描述"},
            {"p-t-115", "湯類", "蚵仔湯", "100", "4.2.png", "產品描述"},
            {"p-t-116", "湯類", "香菇雞湯", "100", "4.3.png", "產品描述"},
            {"p-t-117", "湯類", "鳳梨苦瓜雞", "100", "4.4.png", "產品描述"}
        };

        //一筆放入字典變數product_dict中
        for (String[] item : product_array) {
            Product product = new Product(
                    item[0], 
                    item[1], 
                    item[2], 
                    Integer.parseInt(item[3]), //價格轉為int
                    item[4], 
                    item[5]);
            //將這一筆放入字典變數product_dict中 
            product_dict.put(product.getProduct_id(), product);
        }
        return product_dict; 
    }
}
