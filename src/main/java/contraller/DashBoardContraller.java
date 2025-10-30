package contraller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.dto.CustomerDTO;
import model.dto.EmployeeDTO;
import model.dto.ItemDTO;
import model.dto.SupplierDTO;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DashBoardContraller{

    ObservableList<ItemDTO> itemList = FXCollections.observableArrayList();
    ObservableList<CustomerDTO> customerObservable = FXCollections.observableArrayList();
    ObservableList<SupplierDTO> supplierList = FXCollections.observableArrayList();
    ObservableList<EmployeeDTO> employeeList = FXCollections.observableArrayList();
    String titleArray[] = {"Mr.","Mrs.","Miss"};

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private AnchorPane customerPane;

    @FXML
    private AnchorPane employeePane;

    @FXML
    private AnchorPane itemPane;

    @FXML
    private AnchorPane supplierPane;

    @FXML
    private TableView<CustomerDTO> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    private ChoiceBox<String> txtTitle;

    @FXML
    private TextField txtpostalCode;

    @FXML
    private Button btnCustomer;

    @FXML
    private Button btnEmployee;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnItem;

    @FXML
    private Button btnSupplier;

    @FXML
    private TableColumn<?, ?> colCategory1;

    @FXML
    private TableColumn<?, ?> colCode1;

    @FXML
    private TableColumn<?, ?> colDescription1;

    @FXML
    private TableColumn<?, ?> colPrice1;

    @FXML
    private TableView<ItemDTO> tblItem;

    @FXML
    private TextField txtCategory1;

    @FXML
    private TextField txtCode1;

    @FXML
    private TextField txtDescription1;

    @FXML
    private TextField txtPrice1;

    @FXML
    private TextField txtQty1;

    @FXML
    private TableColumn<?, ?> colQty1;

    @FXML
    private TableColumn<?, ?> colAddress2;

    @FXML
    private TableColumn<?, ?> colCity2;

    @FXML
    private TableColumn<?, ?> colCompanyName2;

    @FXML
    private TableColumn<?, ?> colEmail2;

    @FXML
    private TableColumn<?, ?> colId2;

    @FXML
    private TableColumn<?, ?> colName2;

    @FXML
    private TableColumn<?, ?> colPhone2;

    @FXML
    private TableColumn<?, ?> colPostalCode2;

    @FXML
    private TableColumn<?, ?> colProvince2;

    @FXML
    private TableView<SupplierDTO> tblSupplier;

    @FXML
    private TextField txtAddress2;

    @FXML
    private TextField txtCity2;

    @FXML
    private TextField txtCompanyName2;

    @FXML
    private TextField txtEmail2;

    @FXML
    private TextField txtId2;

    @FXML
    private TextField txtName2;

    @FXML
    private TextField txtPhone2;

    @FXML
    private TextField txtProvince2;

    @FXML
    private TextField txtpostalCode2;

    @FXML
    private TableColumn<?, ?> colAddress3;

    @FXML
    private TableColumn<?, ?> colDOB3;

    @FXML
    private TableColumn<?, ?> colId3;

    @FXML
    private TableColumn<?, ?> colJoinDarte3;

    @FXML
    private TableColumn<?, ?> colNIC3;

    @FXML
    private TableColumn<?, ?> colName3;

    @FXML
    private TableColumn<?, ?> colPhone3;

    @FXML
    private TableColumn<?, ?> colPosition3;

    @FXML
    private TableColumn<?, ?> colSalary3;

    @FXML
    private TableColumn<?, ?> colStatus3;

    @FXML
    private TableView<EmployeeDTO> tblEmployee;

    @FXML
    private TextField txtAddress3;

    @FXML
    private DatePicker txtDate3;

    @FXML
    private TextField txtId3;

    @FXML
    private DatePicker txtJoinDate3;

    @FXML
    private TextField txtNIC3;

    @FXML
    private TextField txtName3;

    @FXML
    private TextField txtPhone3;

    @FXML
    private TextField txtPosition3;

    @FXML
    private TextField txtSalary3;

    @FXML
    private TextField txtStatus3;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private AnchorPane loginPane;

    @FXML
    private Button btnLogOut;

    @FXML
    void btnCustomerAction(ActionEvent event) {
        itemPane.setVisible(false);
        customerPane.setVisible(true);
        supplierPane.setVisible(false);
        employeePane.setVisible(false);
        btnCustomer.setStyle("-fx-background-color: #836fff; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnHome.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnEmployee.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnItem.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnSupplier.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        txtTitle.getItems().addAll(titleArray);
        customerObservable.clear();
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtProvince.setText("");
        txtpostalCode.setText("");
        txtSalary.setText("");
        txtCity.setText("");
        txtDate.setValue(null);
        txtTitle.setValue(null);
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Customer");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                customerObservable.add(new CustomerDTO(
                        resultSet.getString("customer_id"),
                        resultSet.getString("title"),
                        resultSet.getString("name"),
                        resultSet.getString("dob"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getString("postal_code")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        tblCustomer.setItems(customerObservable);

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) ->{
            txtId.setText(newValue.getId());
            txtName.setText(newValue.getName());
            txtAddress.setText(newValue.getAddress());
            txtProvince.setText(newValue.getProvince());
            txtpostalCode.setText(newValue.getPostalCode());
            txtSalary.setText(String.valueOf(newValue.getSalary()));
            txtCity.setText(newValue.getCity());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(newValue.getDob(), formatter);
            txtDate.setValue(localDate);
            if (newValue.getTitle().equals("Mr.")){
                txtTitle.setValue(txtTitle.getItems().get(0));
            } else if (newValue.getTitle().equals("Mrs.")) {
                txtTitle.setValue(txtTitle.getItems().get(1));
            }else if (newValue.getTitle().equals("Miss")){
                txtTitle.setValue(txtTitle.getItems().get(2));
            }
        });
    }

    @FXML
    void btnHomeAction(ActionEvent event) {
        itemPane.setVisible(false);
        customerPane.setVisible(false);
        supplierPane.setVisible(false);
        employeePane.setVisible(false);
        btnCustomer.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnHome.setStyle("-fx-background-color: #836fff; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnEmployee.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnItem.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnSupplier.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");


    }

    @FXML
    void btnItemAction(ActionEvent event) {
        itemPane.setVisible(true);
        customerPane.setVisible(false);
        supplierPane.setVisible(false);
        employeePane.setVisible(false);
        btnCustomer.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnHome.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnEmployee.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnItem.setStyle("-fx-background-color: #836fff; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnSupplier.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        itemList.clear();
        txtCode1.setText("");
        txtDescription1.setText("");
        txtCategory1.setText("");
        txtQty1.setText("");
        txtPrice1.setText("");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Item");
            while (resultSet.next()) {
                itemList.add(new ItemDTO(
                        resultSet.getString("item_code"),
                        resultSet.getString("description"),
                        resultSet.getString("category"),
                        resultSet.getInt("qty_on_hand"),
                        resultSet.getDouble("unit_price")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        colCode1.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription1.setCellValueFactory(new PropertyValueFactory<>("description"));
        colCategory1.setCellValueFactory(new PropertyValueFactory<>("category"));
        colQty1.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colPrice1.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblItem.setItems(itemList);

        tblItem.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtCode1.setText(newValue.getCode());
            txtDescription1.setText(newValue.getDescription());
            txtCategory1.setText(newValue.getCategory());
            txtPrice1.setText(String.valueOf(newValue.getUnitPrice()));
            txtQty1.setText(String.valueOf(newValue.getQtyOnHand()));
        });
    }

    @FXML
    void btnLogOutAction(ActionEvent event) {
        itemPane.setVisible(false);
        customerPane.setVisible(false);
        supplierPane.setVisible(false);
        employeePane.setVisible(false);
        loginPane.setVisible(true);
        btnCustomer.setDisable(true);
        btnItem.setDisable(true);
        btnSupplier.setDisable(true);
        btnEmployee.setDisable(true);
        btnLogOut.setDisable(true);
        btnCustomer.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnHome.setStyle("-fx-background-color: #836fff; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnEmployee.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnItem.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnSupplier.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");

    }

    public void btnCustomerAddAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String title = txtTitle.getValue();
        String name = txtName.getText();
        String dob = String.valueOf(txtDate.getValue());
        Double salary = Double.valueOf(txtSalary.getText());
        String city = txtCity.getText();
        String province = txtProvince.getText();
        String postalCode = txtpostalCode.getText();
        String address = txtAddress.getText();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,title);
            preparedStatement.setString(3,name);
            preparedStatement.setString(4,dob);
            preparedStatement.setDouble(5,salary);
            preparedStatement.setString(6,address);
            preparedStatement.setString(7,city);
            preparedStatement.setString(8,province);
            preparedStatement.setString(9,postalCode);
            int i = preparedStatement.executeUpdate();

            if (i>0){
                new Alert(Alert.AlertType.INFORMATION, "Customer Added successfully!").show();
                customerObservable.add(new CustomerDTO(id,title,name,dob,salary,address,city,province,postalCode));
                tblCustomer.refresh();

            }else {
                new Alert(Alert.AlertType.WARNING, "Customer not found!").show();
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
            throw new RuntimeException(e);
        }
    }

    public void btnCustomerDeleteAction(ActionEvent actionEvent) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Customer WHERE customer_id = ?");
            preparedStatement.setString(1,txtId.getText());
            int i = preparedStatement.executeUpdate();

            if (i>0){
                new Alert(Alert.AlertType.INFORMATION, "Customer Deleted successfully!").show();
                customerObservable.remove(tblCustomer.getSelectionModel().getSelectedItem());
                tblCustomer.refresh();
            }else {
                new Alert(Alert.AlertType.WARNING, "Customer not found!").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnCustomerUpdateAction(ActionEvent actionEvent) {
        CustomerDTO dto = tblCustomer.getSelectionModel().getSelectedItem();


        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
            String sql = "UPDATE Customer SET title=?, name=?, dob=?, salary=?, address=?, city=?, province=?, postal_code=? WHERE customer_id=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, txtTitle.getValue());
            pstm.setString(2, txtName.getText());
            pstm.setString(3, String.valueOf(txtDate.getValue()));
            pstm.setString(4, txtSalary.getText());
            pstm.setString(5, txtAddress.getText());
            pstm.setString(6, txtCity.getText());
            pstm.setString(7, txtProvince.getText());
            pstm.setString(8, txtpostalCode.getText());
            pstm.setString(9, txtId.getText());
            int i = pstm.executeUpdate();

            if (i>0){
                new Alert(Alert.AlertType.INFORMATION, "Customer updated successfully!").show();
                dto.setId(txtId.getText());
                dto.setTitle(txtTitle.getValue());
                dto.setName(txtName.getText());
                dto.setDob(String.valueOf(txtDate.getValue()));
                dto.setCity(txtCity.getText());
                dto.setAddress(txtAddress.getText());
                dto.setProvince(txtProvince.getText());
                dto.setSalary(Double.valueOf(txtSalary.getText()));
                dto.setPostalCode(txtpostalCode.getText());
            }else {
                new Alert(Alert.AlertType.WARNING, "Customer not found!").show();
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
            throw new RuntimeException(e);
        }

        tblCustomer.refresh();
    }

    public void btnCustomerResetAction(ActionEvent actionEvent) {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtProvince.setText("");
        txtpostalCode.setText("");
        txtSalary.setText("");
        txtCity.setText("");
        txtDate.setValue(null);
        txtTitle.setValue(null);
    }
    //Item ADD DELETE UPDATE RESET
    @FXML
    void btnItemAddAction(ActionEvent event) {
        String code = txtCode1.getText();
        String description = txtDescription1.getText();
        String category = txtCategory1.getText();
        int qty = Integer.parseInt(txtQty1.getText());
        Double price = Double.valueOf(txtPrice1.getText());

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "1234");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Item VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, category);
            preparedStatement.setInt(4, qty);
            preparedStatement.setDouble(5, price);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                new Alert(Alert.AlertType.INFORMATION, "Supplier Added successfully!").show();
                itemList.add(new ItemDTO(code, description, category, qty, price));
                tblItem.refresh();
            } else {
                new Alert(Alert.AlertType.WARNING, "Supplier not found!").show();
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnItemDeleteAction(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "1234");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Item WHERE item_code = ?");
            preparedStatement.setString(1, txtCode1.getText());
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                new Alert(Alert.AlertType.INFORMATION, "Item Deleted successfully!").show();
                itemList.remove(tblItem.getSelectionModel().getSelectedItem());
            } else {
                new Alert(Alert.AlertType.WARNING, "Item not found!").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnItemResetAction(ActionEvent event) {
        txtCode1.setText("");
        txtDescription1.setText("");
        txtCategory1.setText("");
        txtQty1.setText("");
        txtPrice1.setText("");
    }

    @FXML
    void btnItemUpdateAction(ActionEvent event) {
        ItemDTO dto = tblItem.getSelectionModel().getSelectedItem();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "1234");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Item SET description=?, category=?, qty_on_hand=?, unit_price=? WHERE item_code=?");
            preparedStatement.setString(1, txtDescription1.getText());
            preparedStatement.setString(2, txtCategory1.getText());
            preparedStatement.setInt(3, Integer.parseInt(txtQty1.getText()));
            preparedStatement.setDouble(4, Double.parseDouble(txtPrice1.getText()));
            preparedStatement.setString(5, txtCode1.getText());
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                new Alert(Alert.AlertType.INFORMATION, "Item Update successfully!").show();
                dto.setCode(txtCode1.getText());
                dto.setDescription(txtDescription1.getText());
                dto.setCategory(txtCategory1.getText());
                dto.setQtyOnHand(Integer.parseInt(txtQty1.getText()));
                dto.setUnitPrice(Double.parseDouble(txtPrice1.getText()));
                tblItem.refresh();
            } else {
                new Alert(Alert.AlertType.WARNING, "Item not found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
            throw new RuntimeException(e);
        }
    }

    //Supplier ADD DELETE UPDATE RESET
    @FXML
    void btnSupplierAction(ActionEvent event) {
        itemPane.setVisible(false);
        customerPane.setVisible(false);
        supplierPane.setVisible(true);
        employeePane.setVisible(false);
        btnCustomer.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnHome.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnEmployee.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnItem.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnSupplier.setStyle("-fx-background-color: #836fff; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        supplierList.clear();
        txtId2.setText("");
        txtName2.setText("");
        txtCompanyName2.setText("");
        txtAddress2.setText("");
        txtCity2.setText("");
        txtProvince2.setText("");
        txtpostalCode2.setText("");
        txtPhone2.setText("");
        txtEmail2.setText("");
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM supplier");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                supplierList.add(new SupplierDTO(
                        resultSet.getString("supplier_id"),
                        resultSet.getString("name"),
                        resultSet.getString("company_name"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getString("postal_code"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        colId2.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName2.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCompanyName2.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colAddress2.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity2.setCellValueFactory(new PropertyValueFactory<>("city"));
        colPostalCode2.setCellValueFactory(new PropertyValueFactory<>("province"));
        colProvince2.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        colPhone2.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail2.setCellValueFactory(new PropertyValueFactory<>("email"));

        tblSupplier.setItems(supplierList);

        tblSupplier.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->{
            txtId2.setText(newValue.getId());
            txtName2.setText(newValue.getName());
            txtCompanyName2.setText(newValue.getCompanyName());
            txtAddress2.setText(newValue.getAddress());
            txtCity2.setText(newValue.getCity());
            txtProvince2.setText(newValue.getProvince());
            txtpostalCode2.setText(newValue.getPostalCode());
            txtPhone2.setText(newValue.getPhone());
            txtEmail2.setText(newValue.getEmail());
        });
    }

    @FXML
    void btnSupplierAddAction(ActionEvent event) {
        String id = txtId2.getText();
        String name = txtName2.getText();
        String companyName = txtCompanyName2.getText();
        String address = txtAddress2.getText();
        String city = txtCity2.getText();
        String province = txtProvince2.getText();
        String postalCode = txtpostalCode2.getText();
        String phone = txtPhone2.getText();
        String email = txtEmail2.getText();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "1234");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO supplier VALUES (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, companyName);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, city);
            preparedStatement.setString(6, province);
            preparedStatement.setString(7, postalCode);
            preparedStatement.setString(8, phone);
            preparedStatement.setString(9, email);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                new Alert(Alert.AlertType.INFORMATION, "Supplier Added successfully!").show();
                supplierList.add(new SupplierDTO(id, name, companyName, address, city, province, postalCode, phone, email));
                tblSupplier.refresh();
            } else {
                new Alert(Alert.AlertType.WARNING, "Supplier not found!").show();
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSupplierDeleteAction(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM supplier WHERE supplier_id = ?");
            preparedStatement.setString(1,txtId2.getText());
            int i = preparedStatement.executeUpdate();
            if (i>0){
                new Alert(Alert.AlertType.INFORMATION, "Supplier Deleted successfully!").show();
                supplierList.remove(tblSupplier.getSelectionModel().getSelectedItem());
            }else {
                new Alert(Alert.AlertType.WARNING, "Supplier not found!").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSupplierResetAction(ActionEvent event) {
        txtId2.setText("");
        txtName2.setText("");
        txtCompanyName2.setText("");
        txtAddress2.setText("");
        txtCity2.setText("");
        txtProvince2.setText("");
        txtpostalCode2.setText("");
        txtPhone2.setText("");
        txtEmail2.setText("");
    }

    @FXML
    void btnSupplierUpdateAction(ActionEvent event) {
        SupplierDTO dto = tblSupplier.getSelectionModel().getSelectedItem();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE supplier SET name=?, company_name=?, address=?, city=?, province=?, postal_code=?, phone=?, email=? WHERE supplier_id=?");
            preparedStatement.setString(1,txtName2.getText());
            preparedStatement.setString(2,txtCompanyName2.getText());
            preparedStatement.setString(3,txtAddress2.getText());
            preparedStatement.setString(4,txtCity2.getText());
            preparedStatement.setString(5,txtProvince2.getText());
            preparedStatement.setString(6,txtpostalCode2.getText());
            preparedStatement.setString(7,txtPhone2.getText());
            preparedStatement.setString(8,txtEmail2.getText());
            preparedStatement.setString(9,txtId2.getText());
            int i = preparedStatement.executeUpdate();
            if (i>0){
                new Alert(Alert.AlertType.INFORMATION, "Supplier Update successfully!").show();

            }else {
                new Alert(Alert.AlertType.WARNING, "Supplier not found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
            throw new RuntimeException(e);
        }

        if (dto != null) {
            dto.setId(txtId2.getText());
            dto.setName(txtName2.getText());
            dto.setCompanyName(txtCompanyName2.getText());
            dto.setAddress(txtAddress2.getText());
            dto.setCity(txtCity2.getText());
            dto.setProvince(txtProvince2.getText());
            dto.setPostalCode(txtpostalCode2.getText());
            dto.setPhone(txtPhone2.getText());
            dto.setEmail(txtEmail2.getText());
            tblSupplier.refresh();
        }
    }


    //Employee ADD DELETE UPDATE RESET
    @FXML
    void btnEmployeeAction(ActionEvent event) {
        itemPane.setVisible(false);
        customerPane.setVisible(false);
        supplierPane.setVisible(false);
        employeePane.setVisible(true);
        btnCustomer.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnHome.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnEmployee.setStyle("-fx-background-color: #836fff; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnItem.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        btnSupplier.setStyle("-fx-background-color: #ffffff15; -fx-text-fill: white; -fx-background-radius: 10; -fx-cursor: hand;");
        employeeList.clear();
        txtId3.clear();
        txtName3.clear();
        txtNIC3.clear();
        txtDate3.setValue(null);
        txtPosition3.clear();
        txtSalary3.clear();
        txtPhone3.clear();
        txtAddress3.clear();
        txtJoinDate3.setValue(null);
        txtStatus3.clear();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employeeList.add(new EmployeeDTO(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("nic"),
                        resultSet.getString("dob"),
                        resultSet.getString("position"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("contact_number"),
                        resultSet.getString("address"),
                        resultSet.getString("joined_date"),
                        resultSet.getString("status")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        colId3.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName3.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNIC3.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colDOB3.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colPosition3.setCellValueFactory(new PropertyValueFactory<>("position"));
        colSalary3.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colPhone3.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colAddress3.setCellValueFactory(new PropertyValueFactory<>("address"));
        colStatus3.setCellValueFactory(new PropertyValueFactory<>("status"));
        colJoinDarte3.setCellValueFactory(new PropertyValueFactory<>("joinedDate"));

        tblEmployee.setItems(employeeList);

        tblEmployee.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)->{
            txtId3.setText(newValue.getId());
            txtName3.setText(newValue.getName());
            txtNIC3.setText(newValue.getNic());
            txtDate3.setValue(LocalDate.parse(newValue.getDob()));
            txtPosition3.setText(newValue.getPosition());
            txtSalary3.setText(String.valueOf(newValue.getSalary()));
            txtPhone3.setText(newValue.getContactNumber());
            txtAddress3.setText(newValue.getAddress());
            txtJoinDate3.setValue(LocalDate.parse(newValue.getJoinedDate()));
            txtStatus3.setText(newValue.getStatus());
        });
    }

    @FXML
    void btnEmployeeAddAction(ActionEvent event) {
        String id = txtId3.getText();
        String name = txtName3.getText();
        String nic = txtNIC3.getText();
        String dob = txtDate3.getValue().toString();
        String position = txtPosition3.getText();
        double salary = Double.parseDouble(txtSalary3.getText());
        String contactNumber = txtPhone3.getText();
        String address = txtAddress3.getText();
        String joinedDate = txtJoinDate3.getValue().toString();
        String status = txtStatus3.getText();


        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Employee (id, name, nic, dob, position, salary, contact_number, address, joined_date, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,nic);
            preparedStatement.setString(4,dob);
            preparedStatement.setString(5,position);
            preparedStatement.setDouble(6,salary);
            preparedStatement.setString(7,contactNumber);
            preparedStatement.setString(8,address);
            preparedStatement.setString(9,joinedDate);
            preparedStatement.setString(10,status);
            int i = preparedStatement.executeUpdate();
            if (i>0){
                new Alert(Alert.AlertType.INFORMATION, "employee Added successfully!").show();
                employeeList.add(new EmployeeDTO(id, name, nic, dob, position, salary, contactNumber, address, joinedDate, status));
                tblEmployee.refresh();

            }else {
                new Alert(Alert.AlertType.WARNING, "employee not found!").show();
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnEmployeeDeleteAction(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE id = ?");
            preparedStatement.setString(1,txtId3.getText());
            int i = preparedStatement.executeUpdate();
            if (i>0){
                new Alert(Alert.AlertType.INFORMATION, "employee Deleted successfully!").show();
                employeeList.remove(tblEmployee.getSelectionModel().getSelectedItem());
            }else {
                new Alert(Alert.AlertType.WARNING, "employee not found!").show();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnEmployeeResetAction(ActionEvent event) {
        txtId3.clear();
        txtName3.clear();
        txtNIC3.clear();
        txtDate3.setValue(null);
        txtPosition3.clear();
        txtSalary3.clear();
        txtPhone3.clear();
        txtAddress3.clear();
        txtJoinDate3.setValue(null);
        txtStatus3.clear();
    }

    @FXML
    void btnEmployeeUpdateAction(ActionEvent event) {
        EmployeeDTO dto = tblEmployee.getSelectionModel().getSelectedItem();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee SET name=?, nic=?, dob=?, position=?, salary=?, contact_number=?, address=?, joined_date=?, status=? WHERE id=?");
            preparedStatement.setString(1,txtName3.getText());
            preparedStatement.setString(2,txtNIC3.getText());
            preparedStatement.setString(3, String.valueOf(txtDate3.getValue()));
            preparedStatement.setString(4,txtPosition3.getText());
            preparedStatement.setDouble(5, Double.parseDouble(txtSalary3.getText()));
            preparedStatement.setString(6,txtPhone3.getText());
            preparedStatement.setString(7,txtAddress3.getText());
            preparedStatement.setString(8, String.valueOf(txtJoinDate3.getValue()));
            preparedStatement.setString(9,txtStatus3.getText());
            preparedStatement.setString(10,txtId3.getText());
            int i = preparedStatement.executeUpdate();
            if (i>0){
                new Alert(Alert.AlertType.INFORMATION, "Emplpoyee updated successfully!").show();
                dto.setId(txtId3.getText());
                dto.setName(txtName3.getText());
                dto.setNic(txtNIC3.getText());
                dto.setDob(txtDate3.getValue().toString());
                dto.setPosition(txtPosition3.getText());
                dto.setSalary(Double.parseDouble(txtSalary3.getText()));
                dto.setContactNumber(txtPhone3.getText());
                dto.setAddress(txtAddress3.getText());
                dto.setJoinedDate(txtJoinDate3.getValue().toString());
                dto.setStatus(txtStatus3.getText());
                tblEmployee.refresh();
            }else {
                new Alert(Alert.AlertType.WARNING, "Emplpoyee not found!").show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    //--------------------------------------Login From----------------------------------------->
    String[] usernameArray = {"pasindu", "tharindu", "lahiru", "navindu"};
    String[] passwordArray = {"12345", "23456", "34567", "45678"};
    public int searchIndex(String[] stringArray, String user) {
        int count = 0;
        for (String username : stringArray) {
            if (username.equals(user)) {
                return count;
            }
            count++;
        }
        return -1;
    }

    public boolean log(String user, String pass) {
        return true;
    }

    @FXML
    void btnLoginAction(ActionEvent event) {

        if (searchIndex(usernameArray, txtUserName.getText()) >= 0 && passwordArray[searchIndex(usernameArray, txtUserName.getText())].equals(txtPassword.getText())) {
            loginPane.setVisible(false);
            btnCustomer.setDisable(false);
            btnItem.setDisable(false);
            btnSupplier.setDisable(false);
            btnEmployee.setDisable(false);
            btnLogOut.setDisable(false);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Username or password is incorrect.");
            alert.showAndWait();
        }
    }

    @FXML
    void btnpasswordAction(ActionEvent actionEvent) {
        if (txtPassword.getText().equals("")) {
            txtUserName.requestFocus();
        } else {
            btnLoginAction(actionEvent);
        }
    }

    @FXML
    void btnuserName(ActionEvent event) {
        txtPassword.requestFocus();
    }


}


