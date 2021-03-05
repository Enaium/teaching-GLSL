# GLSL

```java
GLSL glsl = new GLSL("/shaders/noise");
GL20.glUseProgram(glsl.program);
// GL20.glUniform1f(GL20.glGetUniformLocation(glsl.program, "time"), (System.currentTimeMillis() - start) / 1000f);
// GL20.glUniform2f(GL20.glGetUniformLocation(glsl.program, "resolution"), width, height);

GL11.glBegin(GL11.GL_QUADS);
GL11.glVertex2f(-1, -1);
GL11.glVertex2f(-1, 1);
GL11.glVertex2f(1, 1);
GL11.glVertex2f(1, -1);
GL11.glEnd();

GL20.glUseProgram(0);
```