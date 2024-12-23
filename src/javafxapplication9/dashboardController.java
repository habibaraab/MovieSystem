/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication9;

/**
 *
 * @Habiba Rajab
 */
import com.mysql.cj.xdevapi.Statement;
import com.mysql.cj.jdbc.StatementImpl;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.sql.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.*;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class dashboardController implements Initializable {

    private Image image;

    @FXML
    private Label usrename;

    @FXML
    private Button dash_btn;

    @FXML
    private Button addMovie_btn;

    @FXML
    private Button avaliableMov_btn;

    @FXML
    private Button editScr_btn;

    @FXML
    private Button cust_btn;

    @FXML
    private Button signOut_btn;

    @FXML
    private AnchorPane dash_form;

    @FXML
    private Label dash_totalSold;

    @FXML
    private Label dash_totIncome;

    @FXML
    private Label dash_avaliableMovie;

    @FXML
    private AnchorPane addMovie;

    @FXML
    private ImageView addMovie_viewImg;

    @FXML
    private Button addMovie_import;

    @FXML
    private TextField addMovie_movTitle;

    @FXML
    private TextField addMovie_genre;

    @FXML
    private TextField addMovie_duration;

    @FXML
    private DatePicker addMovie_pubDate;

    @FXML
    private Button addMovie_insert;

    @FXML
    private Button addMovie_update;

    @FXML
    private Button addMovie_delete;

    @FXML
    private Button addMovie_clear;

    @FXML
    private TableView<moviesData> addMovie_tableView;

    @FXML
    private TableColumn<moviesData, String> addMovie_col_movTitle;

    @FXML
    private TableColumn<moviesData, String> addMovie_col_genre;

    @FXML
    private TableColumn<moviesData, String> addMovie_col_duration;

    @FXML
    private TableColumn<moviesData, Date> addMovie_col_publishDate;

    @FXML
    private TextField addMovie_search;

    @FXML
    private AnchorPane availableMovie;

    @FXML
    private Button avalMovie_selectMov;

    @FXML
    private Label avalMovie_movTitle;

    @FXML
    private Label avalMovie_genre;

    @FXML
    private Label avalMovie_date;

    @FXML
    private TableView<moviesData> avalMovie_tableView;

    @FXML
    private TableColumn<moviesData, String> avalMovie_col_movTitle;

    @FXML
    private TableColumn<moviesData, String> avalMovie_col_genre;

    @FXML
    private TableColumn<moviesData, String> avalMovie_col_date;

    @FXML
    private ImageView avalMovie_imgView;

    @FXML
    private Label avalMovie_title;

    @FXML
    private Spinner<Integer> avalMovie_special_quantity;

    @FXML
    private Spinner<Integer> avalMovie_normal_quantity;

    @FXML
    private Label avalMovie_special_price;

    @FXML
    private Label avalMovie_normal_price;

    @FXML
    private Label avalMovie_total;

    @FXML
    private Button avalMovie_buyBtn;

    @FXML
    private Button avalMovie_recBtn;

    @FXML
    private Button avalMovie_clearBtn;

    @FXML
    private AnchorPane EditScreeing;

    @FXML
    private ImageView EditSear_imgView;

    @FXML
    private Label EditSear_title;

    @FXML
    private Button EditSear_update;

    @FXML
    private Button EditSear_delete;

    @FXML
    private ComboBox<?> EditSear_cuurent;

    @FXML
    private TableView<moviesData> EditSear_tableView;

    @FXML
    private TableColumn<moviesData, String> EditSear_col_movtitle;

    @FXML
    private TableColumn<moviesData, String> EditSear_col_genre;

    @FXML
    private TableColumn<moviesData, String> EditSear_col_duar;

    @FXML
    private TableColumn<moviesData, String> EditSear_col_curr;

    @FXML
    private TextField EditSear_search;

    @FXML
    private AnchorPane Customer_form;

    @FXML
    private Label customer_ticketNum;

    @FXML
    private Label customer_movTit;

    @FXML
    private Label customer_genre;

    @FXML
    private Label customer_date;

    @FXML
    private Label customer_time;

    @FXML
    private Button customer_clear;

    @FXML
    private Button customer_delete;

    @FXML
    private TableView<customerData> customer_tableView;

    @FXML
    private TableColumn<customerData, Integer> customer_col_tickNum;

    @FXML
    private TableColumn<customerData, String> customer_col_movTit;

    @FXML
    private TableColumn<customerData, Date> customer_col_date;

    @FXML
    private TableColumn<customerData, Time> customer_col_time;

    @FXML
    private TextField customer_search;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private int countId;

    private ObservableList<customerData> custList() {

        ObservableList<customerData> custL = FXCollections.observableArrayList();

        String sql = "select * from customer";
        connect = database.getCon();

        try {
            customerData custD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                custD = new customerData(result.getInt("id"),
                        result.getString("type"), result.getString("movieTitle"),
                        result.getDouble("total"),
                        result.getDate("date"),
                        result.getTime("time")
                );
                custL.add(custD);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return custL;

    }

    private ObservableList<customerData> custList;

    public void showCustList() {
        custList = custList();

        customer_col_tickNum.setCellValueFactory(new PropertyValueFactory<>("id"));
        customer_col_movTit.setCellValueFactory(new PropertyValueFactory<>("title"));
        customer_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        customer_col_time.setCellValueFactory(new PropertyValueFactory<>("time"));

        customer_tableView.setItems(custList);

    }

    public void selectCustList() {

        customerData custD = customer_tableView.getSelectionModel().getSelectedItem();

        int num = customer_tableView.getSelectionModel().getSelectedIndex();

        if (num - 1 < -1) {

            return;

        }

        customer_ticketNum.setText(String.valueOf(custD.getId()));
        customer_movTit.setText(custD.getTitle());
        customer_date.setText(String.valueOf(custD.getDate()));
        customer_time.setText(String.valueOf(custD.getTime()));

    }
    
    public void deleteCust() {
        String sql = "delete from customer where id ='" + customer_ticketNum.getText() + "'";
        connect = database.getCon();

        try {
            Alert alert;
            prepare = connect.prepareStatement(sql);

            if(customer_ticketNum.getText().isEmpty()||
                    customer_movTit.getText().isEmpty()||
                    customer_date.getText().isEmpty()||
                    customer_time.getText().isEmpty()
                    ){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText( "Please select the movie first!");
            alert.showAndWait();
            
            }
            else{
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure to want delete " + customer_movTit.getText() + " ?");

            Optional<ButtonType> option = alert.showAndWait();

            if (ButtonType.OK.equals(option.get())) {
                prepare.executeUpdate(sql);

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully deleted!");
                alert.showAndWait();

                clearCust();
                showCustList();

            }}
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void clearCust() {

        customer_ticketNum.setText("");
        customer_movTit.setText("");
        customer_date.setText("");
        customer_time.setText("");
    }

    private int soldTik;

    public void countTik() {

        String sql = "select count(id) from customer";

        connect = database.getCon();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                soldTik = result.getInt("count(id)");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void disTotalSold() {
        countTik();
        dash_totalSold.setText(String.valueOf(soldTik));
    }

    private float totalIncome;

    public void totalIncome() {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "select sum(total) from customer where date ='" + String.valueOf(sqlDate) + "'";

        connect = database.getCon();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                totalIncome = (float) result.getDouble("sum(total)");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void disTotal() {
        totalIncome();
        dash_totIncome.setText(String.valueOf(totalIncome));

    }

    private int totalMovies;

    public void avaliableMoviesCount() {
        String sql = "select count(id) from movie where current ='Showing'";

        connect = database.getCon();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                totalMovies = result.getInt("count(id)");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void disaval() {
        avaliableMoviesCount();
        dash_avaliableMovie.setText(String.valueOf(totalMovies));

    }

    private ObservableList<moviesData> avaliableMovList() {

        ObservableList<moviesData> listMovies = FXCollections.observableArrayList();

        String sql = "select *from movie where current ='Showing'";

        connect = database.getCon();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            moviesData movD;
            while (result.next()) {

                movD = new moviesData(result.getInt("id"),
                        result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("current")
                );
                listMovies.add(movD);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return listMovies;
    }

    private ObservableList<moviesData> avaliableMovList;

    public void showAvaliableMov() {

        avaliableMovList = avaliableMovList();

        avalMovie_col_movTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        avalMovie_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));

        avalMovie_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        avalMovie_tableView.setItems(avaliableMovList);

        // showAddMoviesList();
    }

    public void selectAvaliableMov() {

        moviesData movD = avalMovie_tableView.getSelectionModel().getSelectedItem();

        int num = avalMovie_tableView.getSelectionModel().getSelectedIndex();

        if (num - 1 < -1) {

            return;

        }

        avalMovie_movTitle.setText(movD.getTitle());
        avalMovie_genre.setText(movD.getGenre());
        avalMovie_date.setText(String.valueOf(movD.getDate()));

        getData.path = movD.getImage();
        getData.title = movD.getTitle();
    }

    public void selectMovie() {

        Alert alert;
       if(avalMovie_movTitle.getText().isEmpty()||avalMovie_genre.getText().isEmpty()
               ||avalMovie_date.getText().isEmpty()
               ) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText( "Please select the movie first!");
            alert.showAndWait();
       
       
       
       }else{
     
        String url = "file:" + getData.path;

        image = new Image(url, 195, 175, false, true);
        avalMovie_imgView.setImage(image);

        avalMovie_title.setText(getData.title);
        avalMovie_movTitle.setText("");
        avalMovie_genre.setText("");
        avalMovie_date.setText("");

    }}

    private SpinnerValueFactory<Integer> s1;
    private SpinnerValueFactory<Integer> s2;

    private float p1 = 0, p2 = 0, tot = 0;
    private int q1 = 0, q2 = 0;

    public void showSpinnerValue() {
        s1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        s2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);

        avalMovie_special_quantity.setValueFactory(s1);
        avalMovie_normal_quantity.setValueFactory(s2);

    }

    public void getSpinnerVal() {
        q1 = avalMovie_special_quantity.getValue();
        q2 = avalMovie_normal_quantity.getValue();

        p1 = (q1 * 30);
        p2 = (q2 * 20);
        tot = p1 + p2;
        avalMovie_special_price.setText("$" + String.valueOf(p1));
        avalMovie_normal_price.setText("$" + String.valueOf(p2));

        avalMovie_total.setText("$" + String.valueOf(tot));

    }
    
    public void buy() {
    String sql = "INSERT INTO customer (type, movieTitle, total, date, time) VALUES (?, ?, ?, ?, ?)";
    connect = database.getCon();
    String type = "";

    // Determine the ticket type
    if (p1 > 0 && p2 == 0) {
        type = "Special Class";
    } else if (p2 > 0 && p1 == 0) {
        type = "Normal Class";
    } else if (p1 > 0 && p2 > 0) {
        type = "Special & Normal Class";
    }

    Date date = new Date();
    java.sql.Date setDate = new java.sql.Date(date.getTime());

    try {
        Alert alert;
        LocalTime local = LocalTime.now();
        Time time = Time.valueOf(local);

        // Check for missing movie selection or quantity
        if (avalMovie_imgView.getImage() == null || avalMovie_title.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select a movie first!");
            alert.showAndWait();
            return;
        }

        if (p1 == 0 && p2 == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please specify the quantity of tickets you want to purchase!");
            alert.showAndWait();
            return;
        }

        // Prepare and execute the SQL statement for customer
        prepare = connect.prepareStatement(sql);
        prepare.setString(1, type);
        prepare.setString(2, avalMovie_title.getText());
        prepare.setString(3, String.valueOf(tot));
        prepare.setString(4, String.valueOf(setDate));
        prepare.setString(5, String.valueOf(time));
        prepare.executeUpdate();

        // Alert for successful purchase
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("Purchase successful!");
        alert.showAndWait();

        // Fetch the latest customer ID
        String sql1 = "SELECT * FROM customer";
        prepare = connect.prepareStatement(sql1);
        result = prepare.executeQuery();
        int num = 0;
        while (result.next()) {
            num = result.getInt("id");
        }

        // Insert into customer_info table
        String sql2 = "INSERT INTO customer_info (customer_id, type, total, movieTitle) VALUES (?, ?, ?, ?)";
        prepare = connect.prepareStatement(sql2);
        prepare.setString(1, String.valueOf(num));
        prepare.setString(2, type);
        prepare.setString(3, String.valueOf(tot));
        prepare.setString(4, avalMovie_title.getText());
        prepare.execute();

        // Clear purchase form
        clearpur();

    } catch (Exception e) {
        System.out.println(e.getMessage());
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("An error occurred during the purchase process. Please try again.");
        alert.showAndWait();
    }
}


 /*   public void buy(ActionEvent e) {

      

        String sql = "insert into customer (type,movieTitle,total,date,time) values (?,?,?,?,?)";

        connect = database.getCon();
        String type = "";

        if (p1 > 0 && p2 == 0) {
            type = "Special Class";

        } else if (p2 > 0 && p1 == 0) {
            type = "Normal Class";
        } else if (p1 > 0 && p2 > 0) {
            type = "Special & Normal Class";
        }
        Date date = new Date();
        java.sql.Date setDate = new java.sql.Date(date.getTime());

      
        try {

            
            LocalTime local = LocalTime.now();
            Time time = Time.valueOf(local);

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, type);
            prepare.setString(2, avalMovie_title.getText());
            prepare.setString(3, String.valueOf(tot));
            prepare.setString(4, String.valueOf(setDate));
            prepare.setString(5, String.valueOf(time));

              Alert alert;
            if (avalMovie_title.getText().isEmpty() &&    e.getSource()==avalMovie_buyBtn) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select movie !");
                alert.showAndWait();
            }
            else if(e.getSource()==avalMovie_buyBtn){

              
                
             prepare.executeUpdate();
             alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully purchase!");
            alert.showAndWait();
               
            }
            
            
            
          

            
            
            
            
            
            String sql1 = "select * from customer ";

            prepare = connect.prepareStatement(sql1);
            result = prepare.executeQuery();
            int num = 0;
            while (result.next()) {
                num = result.getInt("id");

            }

            String sql2 = "insert into customer_info (customer_id,type,total,movieTitle)values(?,?,?,?)";

            prepare = connect.prepareStatement(sql2);
            prepare.setString(1, String.valueOf(num));
            prepare.setString(2, type);
            prepare.setString(3, String.valueOf(tot));
            prepare.setString(4, avalMovie_title.getText());
            prepare.execute();
            
            clearpur();

        } catch (Exception ev) {
            System.out.println(ev);
        
       }
    }
*/
    public void clearpur() {
        s1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        s2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);

        avalMovie_special_quantity.setValueFactory(s1);
        avalMovie_normal_quantity.setValueFactory(s2);

        avalMovie_special_price.setText("$0.0");
        avalMovie_normal_price.setText("$0.0");

        avalMovie_total.setText("$0.0");

    }

    private String[] currentList = {"Showing", "End Showing"};

    public void comboBox() {

        List<String> listCurrent = new ArrayList<>();

        for (String data : currentList) {
            listCurrent.add(data);

        }

        ObservableList listC = FXCollections.observableArrayList(listCurrent);

        EditSear_cuurent.setItems(listC);

    }

    private ObservableList<moviesData> editScreeing;

    public void showEdit() {

        editScreeing = editScreening();

        EditSear_col_movtitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        EditSear_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        EditSear_col_duar.setCellValueFactory(new PropertyValueFactory<>("duration"));
        EditSear_col_curr.setCellValueFactory(new PropertyValueFactory<>("current"));

        EditSear_tableView.setItems(editScreeing);
        showAvaliableMov();

    }

    public ObservableList<moviesData> editScreening() {

        ObservableList<moviesData> editList = FXCollections.observableArrayList();

        connect = database.getCon();
        String sql = "select *from movie ";
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            moviesData movD;

            while (result.next()) {
                movD = new moviesData(result.getInt("id"),
                        result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("current")
                );

                editList.add(movD);

            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return editList;

    }

    public void clearEditScreeing() {
        EditSear_title.setText("");
        EditSear_imgView.setImage(null);
        //EditSear_cuurent.setSelectionModel(null);
    }


    
    public void updateEditscreeing() {
    // Check if a movie is selected (EditSear_title must not be empty)
    if (EditSear_title.getText().isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("No movie selected! Please select a movie to update.");
        alert.showAndWait();
        return; // Exit the method as no movie is selected
    }

    // Construct the SQL query
    String sql = "UPDATE movie SET current = ? WHERE movieTitle = ?";
    connect = database.getCon();

    try {
        // Prepare the SQL statement
        prepare = connect.prepareStatement(sql);
        prepare.setString(1, (String) EditSear_cuurent.getSelectionModel().getSelectedItem());
        prepare.setString(2, EditSear_title.getText());

        Alert alert;

        // Check for missing fields
        if (EditSear_title.getText().isEmpty() || EditSear_imgView.getImage() == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the movie and ensure all fields are filled!");
            alert.showAndWait();
        } else {
            // Execute the update
            prepare.executeUpdate();

            // Show success message
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully updated: " + EditSear_title.getText());
            alert.showAndWait();

            // Refresh the list and clear input fields
            showEdit();
            clearEditScreeing();
        }

    } catch (Exception e) {
        System.out.println(e.getMessage());
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("An error occurred while updating the movie. Please try again.");
        alert.showAndWait();
    }
}


    public void selectEditScreeing() {

        moviesData movD = EditSear_tableView.getSelectionModel().getSelectedItem();

        int num = EditSear_tableView.getSelectionModel().getFocusedIndex();

        if (num - 1 < -1) {

            return;

        }
        String url = "file:" + movD.getImage();
        image = new Image(url, 200, 205, false, true);
        EditSear_imgView.setImage(image);
        EditSear_title.setText(movD.getTitle());

    }

    public void DisplayName() {
        usrename.setText(getData.username);
    }

    public void movieId() {
        String sql = "select count(id) from movie";

        connect = database.getCon();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                getData.movieId = result.getInt("count(id)");

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void switchFrom(ActionEvent ev) {
        if (ev.getSource() == dash_btn) {
            dash_form.setVisible(true);
            Customer_form.setVisible(false);
            addMovie.setVisible(false);
            EditScreeing.setVisible(false);
            availableMovie.setVisible(false);
            disTotalSold();
            disTotal();
            disaval();

        } else if (ev.getSource() == cust_btn) {
            dash_form.setVisible(false);
            Customer_form.setVisible(true);
            addMovie.setVisible(false);
            EditScreeing.setVisible(false);
            availableMovie.setVisible(false);
            showCustList();
        } else if (ev.getSource() == editScr_btn) {
            dash_form.setVisible(false);
            Customer_form.setVisible(false);
            addMovie.setVisible(false);
            EditScreeing.setVisible(true);
            availableMovie.setVisible(false);
            showEdit();
        } else if (ev.getSource() == addMovie_btn) {
            dash_form.setVisible(false);
            Customer_form.setVisible(false);
            addMovie.setVisible(true);
            EditScreeing.setVisible(false);
            availableMovie.setVisible(false);
            showAddMoviesList();
        } else if (ev.getSource() == avaliableMov_btn) {
            dash_form.setVisible(false);
            Customer_form.setVisible(false);
            addMovie.setVisible(false);
            EditScreeing.setVisible(false);
            availableMovie.setVisible(true);
            showAvaliableMov();

        }
    }

    public void clearAddMov() {
        addMovie_movTitle.setText("");

        addMovie_genre.setText("");

        addMovie_duration.setText("");

        addMovie_pubDate.setValue(null);
        addMovie_viewImg.setImage(null);

    }

 
    
    public void delAddMov() {
    // Ensure that a movie is selected (movieId should not be null or empty)
    if (addMovie_movTitle.getText().isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("No movie selected! Please select a movie to delete.");
        alert.showAndWait();
        return; // Exit the method as no movie is selected
    }

    String sql = "DELETE FROM movie WHERE movieTitle = ?";
    connect = database.getCon();

    try {
        // Prepare the SQL statement
        prepare = connect.prepareStatement(sql);
        prepare.setString(1, addMovie_movTitle.getText());

        // Confirm deletion
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete \"" + addMovie_movTitle.getText() + "\"?");
        
        Optional<ButtonType> option = alert.showAndWait();

        if (option.isPresent() && option.get() == ButtonType.OK) {
            // Execute the delete operation
            prepare.executeUpdate();

            // Show success message
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully deleted: " + addMovie_movTitle.getText());
            alert.showAndWait();

            // Refresh movie list and clear input fields
            showAddMoviesList();
            clearAddMov();
        }

    } catch (Exception e) {
        System.out.println(e.getMessage());
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("An error occurred while deleting the movie. Please try again.");
        alert.showAndWait();
    }
}

    
   
    
  /*  public void Logout(ActionEvent ev) {

        if (signOut_btn == ev.getSource()) {
            int a = JOptionPane.showConfirmDialog(null, "Do you want to close application?", "Select", JOptionPane.YES_NO_OPTION);
            if (a == 0) {
                System.exit(0);
            }
        }
    }*/
    public void Logout(ActionEvent ev) {
    if (signOut_btn == ev.getSource()) {
       
        int a = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            try {
               
                Stage currentStage = (Stage) ((Node) ev.getSource()).getScene().getWindow();
                currentStage.close();

                // فتح صفحة تسجيل الدخول
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml")); // استبدل Login.fxml باسم ملف صفحة تسجيل الدخول
                Parent root = loader.load();
                Stage loginStage = new Stage();
                loginStage.setScene(new Scene(root));
                loginStage.setTitle("Login");
                loginStage.show();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred while logging out. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}


    public ObservableList<moviesData> addMovies() {
        ObservableList<moviesData> listData = FXCollections.observableArrayList();
        String sql = "select * from movie";
        connect = database.getCon();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            moviesData movD;
            while (result.next()) {
                movD = new moviesData(result.getInt("id"), result.getString("movieTitle"), result.getString("genre"), result.getString("duration"), result.getString("image"), result.getDate("date"), result.getString("current"));
                listData.add(movD);

            }
        } catch (Exception e) {

            System.out.println(e);
        }
        return listData;
    }

    private ObservableList<moviesData> listAddMovies;

    public void showAddMoviesList() {

        listAddMovies = addMovies();
        addMovie_col_movTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        addMovie_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        addMovie_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        addMovie_col_publishDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        addMovie_tableView.setItems(listAddMovies);

    }

    public void selectMoviesAddList() {
        moviesData movD = addMovie_tableView.getSelectionModel().getSelectedItem();
        int n = addMovie_tableView.getSelectionModel().getSelectedIndex();
        if (n - 1 < -1) {
            return;
        }

        getData.path = movD.getImage();
        getData.movieId = movD.getId();
        addMovie_movTitle.setText(movD.getTitle());
        addMovie_genre.setText(movD.getGenre());
        addMovie_duration.setText(movD.getDuaration());
        String getDate = String.valueOf(movD.getDate());

        String url = "file:" + movD.getImage();
        image = new Image(url, 179, 182, false, true);
        addMovie_viewImg.setImage(image);
        //addMovie_pubDate.setValue(movD.getDate().getTime());

    }

    public void importImage() {
        FileChooser open = new FileChooser();
        Stage st = (Stage) addMovie.getScene().getWindow();
        File file = open.showOpenDialog(st);
        if (file != null) {
            image = new Image(file.toURI().toString(), 179, 182, false, true);
            addMovie_viewImg.setImage(image);

            getData.path = file.getAbsolutePath();
        }

    }

 
    public void insertAddmov() {

      
        connect = database.getCon();
        Alert alert;

        try {
            
            
           //String sql1="select movieTitle from movie where movieTitle='"+addMovie_movTitle.getText()+"'";


               if( addMovie_movTitle.getText().isEmpty()
                   ||addMovie_genre.getText().isEmpty()
                       ||addMovie_duration.getText().isEmpty()
                       ||addMovie_pubDate.getValue()==null
                       ||addMovie_viewImg.getImage()==null
                       ){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText( "Please fill all blank fields!");
            alert.showAndWait();
                   
               
               
               
               }else{
               
           String sql = "insert into movie(id,movieTitle,genre,duration,image,date,current)values(?,?,?,?,?,?,?)";

           String url = getData.path;
            url = url.replace("\\", "\\\\");
            movieId();
            String mID = String.valueOf(getData.movieId + 1);

            
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, mID);
            prepare.setString(2, addMovie_movTitle.getText());
            prepare.setString(3, addMovie_genre.getText());
            prepare.setString(4, addMovie_duration.getText());
            prepare.setString(5, url);
            prepare.setString(6, String.valueOf(addMovie_pubDate.getValue()));
            prepare.setString(7, "Showing");
            
             prepare.execute();
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully add new Movie!");
            alert.showAndWait();
            showAddMoviesList();
            clearAddMov();
            
            
               
               }
               
               
            
            }
          
          
        
        

        catch (Exception e) {
            System.out.println(e);
        }

    }


    public void updateAddMovies() {
    String url = getData.path;
    if (url != null) {
        url = url.replace("\\", "\\\\");
    }
    
    // Ensure that a movie is selected (movieId should not be null)
    if (addMovie_movTitle.getText().isEmpty()
                   &&addMovie_genre.getText().isEmpty()
                       &&addMovie_duration.getText().isEmpty()
                       
                       &&addMovie_viewImg.getImage()==null
                       ) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("No movie selected! Please select a movie to update.");
        alert.showAndWait();
        return; // Exit the method as no movie is selected
    }
   

    String sql = "UPDATE movie SET movieTitle = ?, genre = ?, duration = ?, image = ?, date = ? WHERE id = ?";

    connect = database.getCon();
    try {
        Alert alert;

        // Check if any fields are empty
        if (addMovie_movTitle.getText().isEmpty()
                || addMovie_genre.getText().isEmpty()
                || addMovie_duration.getText().isEmpty()
                || addMovie_pubDate.getValue() == null
                || addMovie_viewImg.getImage() == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields before updating!");
            alert.showAndWait();
            return; // Exit the method as fields are incomplete
        }

        // Prepare the SQL statement
        prepare = connect.prepareStatement(sql);
        prepare.setString(1, addMovie_movTitle.getText());
        prepare.setString(2, addMovie_genre.getText());
        prepare.setString(3, addMovie_duration.getText());
        prepare.setString(4, url);
        prepare.setDate(5, java.sql.Date.valueOf(addMovie_pubDate.getValue()));
        prepare.setString(6, String.valueOf(getData.movieId));

        // Execute the update
        prepare.executeUpdate();
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("Successfully updated: " + addMovie_movTitle.getText());
        alert.showAndWait();

        // Refresh movie list and clear input fields
        showAddMoviesList();
        clearAddMov();

    } catch (Exception e) {
        System.out.println(e.getMessage());
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("An error occurred while updating the movie. Please try again.");
        alert.showAndWait();
    }
}

    
    

  public void searAddMovie() {
    FilteredList<moviesData> filter = new FilteredList<>(listAddMovies, e -> true);
    addMovie_search.textProperty().addListener((observable, oldValue, newValue) -> {
        
        filter.setPredicate(predicatMoviesData -> {
   
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }

            String key = newValue.toLowerCase();

            if (predicatMoviesData.getTitle().toLowerCase().contains(key)) {
                return true; 
            } else if (predicatMoviesData.getGenre().toLowerCase().contains(key)) {
                return true; 
            } else if (predicatMoviesData.getDuration().toLowerCase().contains(key)) {
                return true; 
            } else if (predicatMoviesData.getDate().toString().toLowerCase().contains(key)) {
                return true; 
            }
            return false; 
        });
    });

    SortedList<moviesData> sortData = new SortedList<>(filter); 
    sortData.comparatorProperty().bind(addMovie_tableView.comparatorProperty());
    addMovie_tableView.setItems(sortData);
}


   public void searchEditScr() {
    FilteredList<moviesData> filter = new FilteredList<>(editScreeing, e -> true);
    EditSear_search.textProperty().addListener((observable, oldValue, newValue) -> {
        filter.setPredicate(predicatMoviesData -> {
            if (newValue.isEmpty()) {
                return true; // Return all items if the search field is empty
            }
            String key = newValue.toLowerCase();
            return predicatMoviesData.getTitle().toLowerCase().contains(key) ||
                   predicatMoviesData.getGenre().toLowerCase().contains(key) ||
                   predicatMoviesData.getDuaration().toLowerCase().contains(key) ||
                   predicatMoviesData.getCurrent().toLowerCase().contains(key);
        });
    });

    SortedList<moviesData> sortData = new SortedList<>(filter);
    sortData.comparatorProperty().bind(EditSear_tableView.comparatorProperty());
    EditSear_tableView.setItems(sortData);
}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DisplayName();
        showAddMoviesList();
        showEdit();
        comboBox();
        showAvaliableMov();
        showSpinnerValue();
        showCustList();
        disTotalSold();
        disTotal();
        disaval();

    }

}
