package mypos;

import java.util.TreeMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Product;
import models.ReadCategoryProduct;

public class AppMenuV3 extends Application {

    //1宣告全域變數)並取得三種菜單的磁磚窗格，隨時被取用。
    private TilePane menuStirFry = getProductCategoryMenu("快炒類");
    TilePane menuVegetables = getProductCategoryMenu("青菜類");
    TilePane menuFry = getProductCategoryMenu("酥炸類");
    TilePane menuSoup = getProductCategoryMenu("湯類");

    // 產品菜單磁磚窗格，置放你需要用到的菜單
    public TilePane getProductCategoryMenu(String category) {

        //取得產品清單(呼叫靜態方法取得)
        TreeMap<String, Product> product_dict = ReadCategoryProduct.readProduct();
        //磁磚窗格
        TilePane category_menu = new TilePane(); //
        category_menu.setVgap(10);  //垂直間隙
        category_menu.setHgap(10);
        //設定一個 row有4個columns，放不下就放到下一個row
        category_menu.setPrefColumns(4);

        //將產品清單內容一一置放入產品菜單磁磚窗格
        for (String item_id : product_dict.keySet()) {
            //用if選擇產品類別
            if (product_dict.get(item_id).getCategory().equals(category)) {
                //定義新增一筆按鈕
                Button btn = new Button();

                //width, height 按鈕外框的大小，你要自行調整，讓它美觀。沒有設定外框會大小不一不好看
                btn.setPrefSize(120, 120);
                //btn.setText(product_dict.get(item_id).getName()); //不要顯示文字，顯示圖片就好

                //按鈕元件顯示圖片Creating a graphic (image)
                //讀出圖片
                Image img = new Image("/imgs/" + product_dict.get(item_id).getPhoto());
                ImageView imgview = new ImageView(img);//圖片顯示物件
                imgview.setFitHeight(80); //設定圖片高度，你要自行調整，讓它美觀
                imgview.setPreserveRatio(true); //圖片的寬高比維持

                //Setting a graphic to the button
                btn.setGraphic(imgview); //按鈕元件顯示圖片
                category_menu.getChildren().add(btn);  //放入菜單磁磚窗格

                //定義按鈕事件-->點選一次，就加入購物車，再點選一次，數量要+1
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        //新增一筆訂單到order_list (ArrayList)
                        //addToCart(item_id);
                        //order_list.add(new Order("p-109", "新增的果汁", 30, 1));
                        System.out.println(product_dict.get(item_id).getName());
                    }
                });
            }
        }
        return category_menu;
    }//getProductCategoryMenu()

    //2.宣告一個容器(全域變數) menuContainerPane，裝不同種類的菜單，菜單類別選擇按鈕被按下，立即置放該種類的菜單。
    VBox menuContainerPane = new VBox();

    //3.多一個窗格(可以用磁磚窗格最方便)置放菜單類別選擇按鈕，置放於主視窗的最上方區域。
    public TilePane getMenuSelectionContainer() {

        //定義"熱炒類"按鈕
        Button btnStirFry = new Button();
        btnStirFry.setText("熱炒類");
        btnStirFry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menuContainerPane.getChildren().clear();//先刪除原有的窗格再加入新的類別窗格
                menuContainerPane.getChildren().add(menuStirFry);
            }
        });
        //定義"青菜類"按鈕
        Button btnVegetables = new Button("青菜類");
        btnVegetables.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //menuContainerPane.getChildren().clear();//先刪除原有的窗格再加入新的類別窗格
                //menuContainerPane.getChildren().add(menuTea);
                select_category_menu(e);
            }
        });
        //定義"酥炸類"按鈕
        Button btnFry = new Button("酥炸類");
        btnFry.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                select_category_menu(e);
            }
        });
        //定義"湯類"按鈕
        Button btnSoup = new Button("湯類");
        btnFry.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
         select_category_menu( e );
        }
          });

        //使用磁磚窗格，放置前面三個按鈕
        TilePane conntainerCategoryMenuBtn = new TilePane();
        //conntainerCategoryMenuBtn.setAlignment(Pos.CENTER_LEFT);
        //conntainerCategoryMenuBtn.setPrefColumns(6); //
        conntainerCategoryMenuBtn.setVgap(10);
        conntainerCategoryMenuBtn.setHgap(10);

        conntainerCategoryMenuBtn.getChildren().add(btnStirFry);
        conntainerCategoryMenuBtn.getChildren().add(btnVegetables);
        conntainerCategoryMenuBtn.getChildren().add(btnFry);
        //conntainerCategoryMenuBtn.getChildren().add(btnSoup);

        return conntainerCategoryMenuBtn;
    } // getMenuSelectionContainer()方法

    // 前述三個類別按鈕可以呼叫以下事件
    public void select_category_menu(ActionEvent event) {
        String category = ((Button) event.getSource()).getText();
        menuContainerPane.getChildren().clear();//先刪除原有的窗格再加入新的類別窗格
        switch (category) {
            case "熱炒類":
                menuContainerPane.getChildren().add(menuStirFry);
                break;
            case "青菜類":
                menuContainerPane.getChildren().add(menuVegetables);
                break;
            case "酥炸類":
                menuContainerPane.getChildren().add(menuFry);
                break;
            case "湯類":
                menuContainerPane.getChildren().add(menuSoup);
            break;
           
            default:
                break;
        }

    }//select_category_menu

    @Override
    public void start(Stage stage) {
        //根容器 所有的元件都放在裡面container，最後再放進布景中scene，布景再放進舞台中stage
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 10)); //外框內墊片
        root.getStylesheets().add("/css/bootstrap3.css");

        //塞入菜單選擇區塊
        root.getChildren().add(getMenuSelectionContainer());
        TilePane menuSelectionTile = getMenuSelectionContainer();
        root.getChildren().add(menuSelectionTile);

        // 塞入菜單區塊 預設為熱炒類
        menuContainerPane.getChildren().add(menuStirFry);

        //取得菜單磁磚窗格並放入根容器
        root.getChildren().add(menuContainerPane);

        Scene scene = new Scene(root);
        //Scene scene = new Scene(root, 600,800); 
        stage.setTitle("熱炒菜單");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
