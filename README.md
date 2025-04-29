# 📄 Paper Logger

Paper Logger is a simple and clean Java Swing application that lets you log academic papers and save them to a CSV file with ease. The interface features a custom background image, right-aligned labels, and supports both year-only and full-date formats.

[Before]

<img width="699" alt="Screenshot 0007-04-29 at 16 10 38" src="https://github.com/user-attachments/assets/817a5780-3e6f-463d-b3db-61d5e376d680" />

[After] 

<img width="807" alt="Screenshot 0007-04-29 at 16 16 29" src="https://github.com/user-attachments/assets/361682d0-4515-490f-b403-43c51cc12154" />

[After 2] Final Version 

<img width="801" alt="Screenshot 0007-04-29 at 16 43 17" src="https://github.com/user-attachments/assets/4fe8a257-dc7b-427e-82a0-1672a6acf011" />

---

## 🧩 Features

- Intuitive GUI for entering academic paper information:
  - Title
  - Author
  - Year or Date (YYYY or YYYY-MM-DD)
  - Publishing Site
  - Comments
- **SAVE** button writes the entry to `papers.csv`
- **OPEN** button launches `papers.csv` in the system's default CSV viewer (e.g., Excel)
- Background image support via `Paper/990.jpg`
- **Handles commas and quotes inside fields properly** using CSV escape rules
- Loads saved CSV data on launch (for internal use)

---

## 📁 Project Structure

Paper_logger/ 
 ├── Background.java
 ├── Main_GUI_screen.java 
 ├── Open.java 
 ├── Paper.java 
 ├── Save.java Paper/ 
 └── 990.jpg 
 
---

## 💾 Example Output (`papers.csv`)

## 🖼 UI Improvement Summary


  Before	After
  Labels left-aligned	Labels right-aligned
  Vertical layout	Consistent horizontal form layout
  Low visual clarity	Improved readability and balance
  
## 🔧 Tech Stack

  Java Swing for GUI
  File I/O with BufferedReader / BufferedWriter
  Custom CSV formatting with proper escaping of commas and quotes

## 📌 Future Enhancements

  🔍 Title or author-based search and filtering
  🧾 PDF export support
  🗃 Tag-based paper categorization
  ☁ Cloud sync via services like Google Drive
  
## 📝 License

This project is proprietary and all rights are reserved by the original creator, **Seiya Genda**.  
You may use or modify this code for personal or academic purposes, but redistribution, commercial use, or reuploading without explicit permission from the author is prohibited.

© 2025 Seiya Genda. All rights reserved.
