package Controlador;

import Modelo.ReportesDAO;
import Vista.ReportesVista;

public class ReportesControlador {
    public void mostrarReportes() {
        ReportesVista vista = new ReportesVista();
        ReportesDAO dao = new ReportesDAO();

        vista.getBtnActualizar().addActionListener(e -> this.cargarReportes(dao, vista));
        vista.setVisible(true);
    }

    private void cargarReportes(ReportesDAO dao, ReportesVista vista) {
        int totalVisitas = dao.obtenerTotalVisitas();
        int totalProcedimientos = dao.obtenerTotalProcedimientos();
        int totalVacunas = dao.obtenerTotalVacunas();
        double totalFacturacion = dao.obtenerTotalFacturacion();

        vista.mostrarReportes(totalVisitas, totalProcedimientos, totalVacunas, totalFacturacion, dao.obtenerServiciosMasSolicitados());
    }

}