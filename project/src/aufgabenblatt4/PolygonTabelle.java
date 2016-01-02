package aufgabenblatt4;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PolygonTabelle {
	private TableView<Polygon> tabelle;
	private PolygonModell modell;

	public PolygonTabelle(TableView<Polygon> tabelle, PolygonModell modell) {
		this.tabelle = tabelle;
		this.modell = modell;
	}

	public void initTabelle() {
		tabelle.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		List<Polygon> polygone = new ArrayList<Polygon>(modell.getListePolygone());
		final ObservableList<Polygon> daten = FXCollections.observableArrayList(polygone);
		TableColumn<Polygon, String> polys = new TableColumn<>("Polygone");
		polys.setCellValueFactory(new PropertyValueFactory<>("info"));
		tabelle.setItems(daten);
		tabelle.getColumns().add(polys);
	}

	public void refreshTabelle() {
		tabelle.getItems().clear();
		List<Polygon> polygone = new ArrayList<Polygon>(modell.getListePolygone());
		final ObservableList<Polygon> daten = FXCollections.observableArrayList(polygone);
		tabelle.setItems(daten);
	}
}
