import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecipeManager extends JFrame {
    private JTextField idField, nameField, ingredientsField, recipeField;
    private JComboBox<String> typeComboBox;
    private JButton addButton, updateButton;
    private JList<String> recipeList;
    private DefaultListModel<String> listModel;
    private ArrayList<Recipe> recipes;

    public RecipeManager() {
        setTitle("Recipe Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        idField = new JTextField(10);
        inputPanel.add(idField, gbc);

        gbc.gridx = 2;
        inputPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 3;
        nameField = new JTextField(20);
        inputPanel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Ingredients:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3;
        ingredientsField = new JTextField(40);
        inputPanel.add(ingredientsField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1;
        inputPanel.add(new JLabel("Recipe:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3;
        recipeField = new JTextField(40);
        inputPanel.add(recipeField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1;
        inputPanel.add(new JLabel("Type:"), gbc);
        gbc.gridx = 1;
        String[] types = {"Type1", "Type2", "Type3"};
        typeComboBox = new JComboBox<>(types);
        inputPanel.add(typeComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        addButton = new JButton("Add Record");
        inputPanel.add(addButton, gbc);

        gbc.gridx = 2;
        updateButton = new JButton("Update Record");
        inputPanel.add(updateButton, gbc);

        add(inputPanel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        recipeList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(recipeList);
        add(scrollPane, BorderLayout.CENTER);

        recipes = new ArrayList<>();

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addRecipe();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateRecipe();
            }
        });
    }

    private void addRecipe() {
        String id = idField.getText();
        String name = nameField.getText();
        String ingredients = ingredientsField.getText();
        String recipe = recipeField.getText();
        String type = (String) typeComboBox.getSelectedItem();

        Recipe newRecipe = new Recipe(id, name, ingredients, recipe, type);
        recipes.add(newRecipe);
        listModel.addElement(name);

        clearFields();
    }

    private void updateRecipe() {
        int selectedIndex = recipeList.getSelectedIndex();
        if (selectedIndex != -1) {
            Recipe recipe = recipes.get(selectedIndex);
            recipe.setId(idField.getText());
            recipe.setName(nameField.getText());
            recipe.setIngredients(ingredientsField.getText());
            recipe.setRecipe(recipeField.getText());
            recipe.setType((String) typeComboBox.getSelectedItem());

            listModel.set(selectedIndex, recipe.getName());
            clearFields();
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        ingredientsField.setText("");
        recipeField.setText("");
        typeComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RecipeManager().setVisible(true);
            }
        });
    }
}

class Recipe {
    private String id;
    private String name;
    private String ingredients;
    private String recipe;
    private String type;

    public Recipe(String id, String name, String ingredients, String recipe, String type) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.recipe = recipe;
        this.type = type;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }
    public String getRecipe() { return recipe; }
    public void setRecipe(String recipe) { this.recipe = recipe; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
