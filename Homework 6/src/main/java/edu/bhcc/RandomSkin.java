package edu.bhcc;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * RandomSkin Servlet
 * Simple HTML page that has random CSGO skin image with matching description about the image.
 */
public class RandomSkin extends HttpServlet{

    /**
     * Handle HTTP POST request
     *
     * @param request
     * @param response
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter writer = response.getWriter();

        // generate random number for skin
        int randomNum = (int) (Math.random() * (4 - 1 + 1)) + 1;

        writer.println("<html>");
        writer.println("<body>");


        if (randomNum == 1) {
            // image that is centered
            writer.println("<img src='https://images.steamusercontent.com/ugc/17385757937515256697/FF5C10B0A70D99547B5435B041F123EB57361645/' style='display:block; margin:auto; width:300px;' alt='Blue Gem AK47 Skin'>");
            // blurb about blue gem ak47
            writer.println("<p style='display:block; margin:auto; width:300px;'>This is a Blue Gem AK47.</p>");
        } else if (randomNum == 2) {
            // image that is centered
            writer.println("<img src='https://images.steamusercontent.com/ugc/9506346478236677612/4E06E59E3559CC0247F896E79A1633DCE75CF1E9/'  style='display:block; margin:auto; width:300px;' alt='Blue Gem Karambit'>");
            // blurb about blue gem karambit
            writer.println("<p style='display:block; margin:auto; width:300px;'>This is a Blue Gem Karambit.</p>");
        } else if (randomNum == 3) {
            // image that is centered
            writer.println("<img src='https://community.fastly.steamstatic.com/economy/image/i0CoZ81Ui0m-9KwlBY1L_18myuGuq1wfhWSaZgMttyVfPaERSR0Wqmu7LAocGIGz3UqlXOLrxM-vMGmW8VNxu5Dx60noTyLwiYbf_jdk4veqYaF7IfysCnWRxuF4j-B-Xxa_nBovp3Pdwtj9cC_GaAd0DZdwQu9fuhS4kNy0NePntVTbjYpCyyT_3CgY5i9j_a9cBkcCWUKV/360fx360f' style='display:block; margin:auto; width:300px;' alt='Dragon Lore AWP Skin'>");
            // blurb about dragon lore AWP
            writer.println("<p style='display:block; margin:auto; width:300px;'>This is a Dragon Lore AWP.</p>");
        } else if (randomNum == 4) {
            // image that is centered
            writer.println("<img src='https://community.fastly.steamstatic.com/economy/image/i0CoZ81Ui0m-9KwlBY1L_18myuGuq1wfhWSaZgMttyVfPaERSR0Wqmu7LAocGJai0ki7VeTHjM-sJnCW8Vli_YTxuAm2FVLll4Lh8x1T4P6hJqZrJfHAXjXGkr0i4rc_GSjixEh35GSAnNr8IyqSbg8kA8ciRrQJshGm0oqwlCzKr50/360fx360f'  style='display:block; margin:auto; width:300px;' alt='Titan Holo 2014 Sticker'>");
            // blurb about titan holo 2014 sticker
            writer.println("<p style='display:block; margin:auto; width:300px;'>This is a Titan Holo 2014 Sticker.</p>");
        }

        writer.println("</body>");
        writer.println("</html>");
    }
}
