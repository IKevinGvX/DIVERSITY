$(document).ready(function () {
    $('#usuariotable').DataTable();
});
function exportToPDF() {
    const { jsPDF } = window.jspdf;
    const doc = new jsPDF();

    // Agregar un logo (opcional)
    // doc.addImage('logo_url', 'PNG', 10, 10, 30, 30);

    // Título del documento
    doc.setFont("helvetica", "bold");
    doc.setFontSize(18);
    doc.text("Lista de Usuarios", 14, 20);

    // Fecha actual
    const currentDate = new Date().toLocaleDateString();
    doc.setFontSize(10);
    doc.text(`Fecha: ${currentDate}`, 160, 20);

    // Estilo de la tabla
    const table = document.getElementById("usuariotable");
    const data = [];
    const headers = [];

    // Extraer encabezados de la tabla
    const headerCells = table.querySelectorAll("thead th");
    headerCells.forEach((th, index) => {
        if (th.textContent.trim() !== 'Acciones') { // Excluir columna Acciones
            headers.push(th.textContent.trim());
        }
    });

    // Extraer datos de las filas de la tabla
    const rows = table.querySelectorAll("tbody tr");
    rows.forEach((row) => {
        const rowData = [];
        const cells = row.querySelectorAll("td");
        cells.forEach((cell, index) => {
            if (index !== cells.length - 1) { // Excluir la última columna (Acciones)
                rowData.push(cell.textContent.trim());
            }
        });
        data.push(rowData);
    });

    // Configuración de la tabla en el PDF
    doc.autoTable({
        head: [headers], // Utilizar todos los encabezados excepto Acciones
        body: data,
        startY: 30,
        theme: "striped", // Usar filas alternas para mejor legibilidad
        styles: {
            fontSize: 8, // Reducir tamaño de fuente para ajustar más filas en una página
            cellPadding: 2,
            textColor: [0, 0, 0],
            halign: 'center', // Alinear el texto al centro
            overflow: 'linebreak', // Ajustar el texto largo
        },
        headStyles: {
            fillColor: [52, 58, 64], // Color de fondo del encabezado
            textColor: [255, 255, 255], // Color del texto del encabezado
            fontSize: 9,
            fontStyle: "bold",
        },
        alternateRowStyles: {
            fillColor: [240, 240, 240], // Color alterno de filas
        },
        margin: { top: 30 },
        columnStyles: {
            0: { halign: 'center', cellWidth: 20 },
            1: { halign: 'center', cellWidth: 40 },
            2: { halign: 'center', cellWidth: 40 },
            3: { halign: 'center', cellWidth: 20 },
            4: { halign: 'center', cellWidth: 40 },
        },
        pageBreak: 'auto', // Ajustar contenido automáticamente
        showHead: 'everyPage', // Mostrar encabezado en cada página
    });

    // Pie de página
    const pageCount = doc.internal.getNumberOfPages();
    for (let i = 1; i <= pageCount; i++) {
        doc.setPage(i);
        doc.setFontSize(9);
        doc.text(`Página ${i} de ${pageCount}`, doc.internal.pageSize.width - 20, doc.internal.pageSize.height - 10, {
            align: "right",
        });
        doc.text(`Generado el ${currentDate}`, 14, doc.internal.pageSize.height - 10);
    }

    // Guardar el archivo PDF
    doc.save("usuario.pdf");
}


function exportToExcel() {
    const table = document.getElementById("usuariotable");
    const data = [];

    for (let i = 0; i < table.rows.length; i++) {
        if (i === 0 || i === table.rows.length - 1) continue; // Omitir acciones
        const row = [...table.rows[i].cells].slice(0, -1).map(cell => cell.textContent);
        data.push(row);
    }

    const ws = XLSX.utils.aoa_to_sheet(data);
    const wb = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, "Usuarios");
    XLSX.writeFile(wb, "usuarios.xlsx");
}

function exportToXML() {
    const table = document.getElementById("usuariotable");
    let xml = "<usuarios>\n";

    for (let i = 0; i < table.rows.length; i++) {
        if (i === 0 || i === table.rows.length - 1) continue; // Omitir acciones
        const row = [...table.rows[i].cells].slice(0, -1);
        xml += "  <usuarios>\n";

        row.forEach((cell, index) => {
            xml += `    <columna${index + 1}>${cell.textContent}</columna${index + 1}>\n`;
        });

        xml += "  </usuarios>\n";
    }

    xml += "</usuarios>"
    const blob = new Blob([xml], { type: "application/xml" });
    const link = document.createElement("a");
    link.href = URL.createObjectURL(blob);
    link.download = "usuarios.xml";
    link.click();
}