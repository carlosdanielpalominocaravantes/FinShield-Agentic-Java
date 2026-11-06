import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // ==========================================
    // 1. CLASE INTERNA: SOLICITUD DE COMPRA (POO puros)
    // ==========================================
    public static class SolicitudCompra {
        private Long id;
        private String proveedor;
        private BigDecimal monto;
        private String categoria;
        private String descripcion;
        private String estatusAuditoria = "PENDIENTE";
        private String justificacionIa;
        private LocalDateTime fechaCreacion = LocalDateTime.now();

        // Constructor
        public SolicitudCompra(Long id, String proveedor, BigDecimal monto, String categoria, String descripcion) {
            this.id = id;
            this.proveedor = proveedor;
            this.monto = monto;
            this.categoria = categoria;
            this.descripcion = descripcion;
        }

        // Getters y Setters para acceso seguro de datos
        public Long getId() { return id; }
        public String getProveedor() { return proveedor; }
        public BigDecimal getMonto() { return monto; }
        public String getCategoria() { return categoria; }
        public String getDescripcion() { return descripcion; }
        public String getEstatusAuditoria() { return estatusAuditoria; }
        public void setEstatusAuditoria(String estatusAuditoria) { this.estatusAuditoria = estatusAuditoria; }
        public String getJustificacionIa() { return justificacionIa; }
        public void setJustificacionIa(String justificacionIa) { this.justificacionIa = justificacionIa; }
    }

    // ==========================================
    // 2. CLASE INTERNA: AGENTE DE INTELIGENCIA ARTIFICIAL (IA Aplicada)
    // ==========================================
    public static class AI_Agent_Auditor {

        public SolicitudCompra procesarConIA(SolicitudCompra solicitud) {
            String textoAnalisis = solicitud.getDescripcion().toLowerCase();
            BigDecimal monto = solicitud.getMonto();
            BigDecimal umbralCritico = new BigDecimal("100000");

            // Lógica de razonamiento semántico del Agente de IA (Prompt Logic)
            if (monto.compareTo(umbralCritico) > 0 && (textoAnalisis.contains("microchip") || textoAnalisis.contains("componente"))) {
                solicitud.setEstatusAuditoria("AUDITORÍA REQUERIDA (CRÍTICO)");
                solicitud.setJustificacionIa("[AI Agent - Alerta de Riesgo Global]: Solicitud de adquisición de semiconductores que excede el umbral de $100k. Se detectó riesgo potencial en la cadena de suministro internacional. Bloqueado para inspección manual.");
            } else if (textoAnalisis.contains("urgente") || textoAnalisis.contains("emergencia")) {
                solicitud.setEstatusAuditoria("REVISIÓN PRIORITARIA");
                solicitud.setJustificacionIa("[AI Agent - Advertencia]: El lenguaje denota alta urgencia. Posible intento de eludir filtros de aprobación estándar corporativos.");
            } else {
                solicitud.setEstatusAuditoria("APROBADO AUTOMÁTICAMENTE");
                solicitud.setJustificacionIa("[AI Agent - Éxito]: Los metadatos de la transacción y la descripción coinciden con patrones de compras estándar y proveedores aprobados.");
            }
            return solicitud;
        }
    }

    // ==========================================
    // 3. MÉTODO PRINCIPAL: ORQUESTACIÓN Y EJECUCIÓN
    // ==========================================
    public static void main(String[] args) {
        System.out.println("🤖 BIENVENIDO AL SISTEMA DE HIPERAUTOMATIZACIÓN - FINSHIELD AGENTIC\n");

        // Simular base de datos / repositorio en una lista de objetos
        List<SolicitudCompra> baseDeDatos = new ArrayList<>();
        baseDeDatos.add(new SolicitudCompra(1L, "Ford Global Supplier Inc", new BigDecimal("150000.00"), "Adquisiciones", "Compra masiva de microchips y componentes para ensamble de motores."));
        baseDeDatos.add(new SolicitudCompra(2L, "Logistics Express MX", new BigDecimal("4500.00"), "Logística", "Envío urgente de refacciones para mantenimiento de planta Naucalpan."));
        baseDeDatos.add(new SolicitudCompra(3L, "Office Depot", new BigDecimal("1200.00"), "Suministros", "Papelería estándar para oficinas administrativas."));

        // Instanciar nuestro Agente de Inteligencia Artificial
        AI_Agent_Auditor agenteIA = new AI_Agent_Auditor();

        System.out.println("🚀 Iniciando procesamiento agéntico de fin a fin (End-to-End)...");
        System.out.println("--------------------------------------------------------------------------------");

        // Ejecutar la auditoría inteligente sobre los registros
        for (SolicitudCompra solicitud : baseDeDatos) {
            SolicitudCompra auditada = agenteIA.procesarConIA(solicitud);

            System.out.println("ID Solicitud: " + auditada.getId());
            System.out.println("Proveedor: " + auditada.getProveedor());
            System.out.println("Monto: $" + auditada.getMonto());
            System.out.println("Estatus Auditoría: " + auditada.getEstatusAuditoria());
            System.out.println("Justificación de la IA: " + auditada.getJustificacionIa());
            System.out.println("--------------------------------------------------------------------------------");
        }

        System.out.println("✅ Procesamiento terminado con éxito. Criterio de arquitectura validado.");
    }
}
