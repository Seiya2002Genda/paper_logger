// ✅ Paper.java
package Paper_logger;

public class Paper {
    private String title;
    private String author;
    private String yearOrDate;
    private String site;
    private String comment;

    public Paper(String title, String author, String yearOrDate, String site, String comment) {
        this.title = title;
        this.author = author;
        this.yearOrDate = yearOrDate;
        this.site = site;
        this.comment = comment;
    }

    public String toCSV() {
        return escape(title) + "," + escape(author) + "," + yearOrDate + "," + escape(site) + "," + escape(comment);
    }

    public static Paper fromCSV(String line) {
        String[] parts = line.split(",", 5);
        return new Paper(unescape(parts[0]), unescape(parts[1]), parts[2], unescape(parts[3]), unescape(parts[4]));
    }

    private String escape(String field) {
        if (field.contains(",") || field.contains("\"")) {
            field = field.replace("\"", "\"\"");
            return "\"" + field + "\"";
        }
        return field;
    }

    private static String unescape(String field) {
        if (field.startsWith("\"") && field.endsWith("\"")) {
            field = field.substring(1, field.length() - 1);
            return field.replace("\"\"", "\"");
        }
        return field;
    }
}