
A **layout shift** is when visible elements on a web page unexpectedly move from one position to another while the page is loading or during user interaction, without any user input causing the movement.[](https://web.dev/articles/cls)

---
## Why Layout Shift Happens

- Common causes include images or videos without specified dimensions, ads or embeds loading asynchronously, or late-loading fonts and content.
    
- When the browser doesn't know in advance how much space an element will occupy, it can cause the rest of the page to "jump" as the element is loaded.[](https://web.dev/articles/optimize-cls)

---
## Why It's Important

- Layout shifts are measured by the **Cumulative Layout Shift (CLS)** metric, which is part of Google's Core Web Vitals.
    
- A low CLS score (≤ 0.1) provides a better, more stable user experience, while a higher score means users are likely to experience frustrating shifts.[](https://sematext.com/glossary/cumulative-layout-shift/)
    
- Unstable layouts can make users lose their place, click the wrong button, or otherwise disrupt their actions.[](https://gtmetrix.com/cumulative-layout-shift.html)

---
## Example

If an image loads above a block of text and, as it appears, the text is pushed down, that's a layout shift. Properly specifying width and height for images, reserving space for ads or embeds, and optimizing font loads can help avoid unnecessary shifts.