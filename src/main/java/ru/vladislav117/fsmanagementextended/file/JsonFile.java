package ru.vladislav117.fsmanagementextended.file;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.apache.commons.io.FileUtils;
import ru.vladislav117.fsmanagement.FSObject;
import ru.vladislav117.fsmanagement.file.ContentFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Json-файл.
 */
public class JsonFile extends ContentFile<JsonElement> {
    static Gson gson = new Gson();
    protected Charset charset = StandardCharsets.UTF_8;

    /**
     * Создание файла.
     *
     * @param parentObject Родительский объект
     * @param childPath    Путь к дочернему объекту
     */
    public JsonFile(FSObject parentObject, String childPath) {
        super(parentObject, childPath);
    }

    /**
     * Создание файла.
     *
     * @param object Объект
     */
    public JsonFile(FSObject object) {
        super(object);
    }

    /**
     * Создание файла.
     *
     * @param parentObject Родительский объект
     * @param childPath    Путь к дочернему объекту
     */
    public JsonFile(File parentObject, String childPath) {
        super(parentObject, childPath);
    }

    /**
     * Создание файла.
     *
     * @param object Объект
     */
    public JsonFile(File object) {
        super(object);
    }

    /**
     * Создание файла.
     *
     * @param parentPath Родительский путь
     * @param childPath  Путь к дочернему объекту
     */
    public JsonFile(String parentPath, String childPath) {
        super(parentPath, childPath);
    }

    /**
     * Создание файла.
     *
     * @param path Путь
     */
    public JsonFile(String path) {
        super(path);
    }

    /**
     * Получение кодировки файла.
     *
     * @return Кодировка файла.
     */
    public Charset getCharset() {
        return charset;
    }

    /**
     * Установка кодировки файла.
     *
     * @param charset Кодировка
     * @return Этот же файл.
     */
    public JsonFile setCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

    @Override
    protected JsonElement readUnsafe() throws IOException {
        return gson.fromJson(FileUtils.readFileToString(location, charset), JsonElement.class);
    }

    @Override
    protected void writeUnsafe(JsonElement content) throws IOException {
        FileUtils.writeStringToFile(location, gson.toJson(content), charset);
    }
}
