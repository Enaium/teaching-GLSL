package cn.enaium.learn.client;

import org.lwjgl.opengl.GL20;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Project: MCP918
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class GLSL {
    public final int program;

    public GLSL(String fileName) {
        program = GL20.glCreateProgram();

        int vsh = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
        GL20.glShaderSource(vsh, read(fileName + ".vsh"));
        GL20.glCompileShader(vsh);
        GL20.glAttachShader(program, vsh);

        int fsh = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);
        GL20.glShaderSource(fsh, read(fileName + ".fsh"));
        GL20.glCompileShader(fsh);
        GL20.glAttachShader(program, fsh);


        GL20.glLinkProgram(program);
        GL20.glValidateProgram(program);
    }

    private String read(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(GLSL.class.getResource(fileName).getFile()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

}
