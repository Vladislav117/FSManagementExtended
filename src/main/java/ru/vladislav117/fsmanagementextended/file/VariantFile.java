package ru.vladislav117.fsmanagementextended.file;

import org.apache.commons.io.FileUtils;
import ru.vladislav117.fsmanagement.FSObject;
import ru.vladislav117.fsmanagement.file.ContentFile;
import ru.vladislav117.fsmanagement.file.TextFile;
import ru.vladislav117.variant.Variant;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Variant-файл.
 */
public class VariantFile extends ContentFile<Variant> {
    protected Charset charset = StandardCharsets.UTF_8;

    /**
     * Создание файла.
     *
     * @param parentObject Родительский объект
     * @param childPath    Путь к дочернему объекту
     */
    public VariantFile(FSObject parentObject, String childPath) {
        super(parentObject, childPath);
    }

    /**
     * Создание файла.
     *
     * @param object Объект
     */
    public VariantFile(FSObject object) {
        super(object);
    }

    /**
     * Создание файла.
     *
     * @param parentObject Родительский объект
     * @param childPath    Путь к дочернему объекту
     */
    public VariantFile(File parentObject, String childPath) {
        super(parentObject, childPath);
    }

    /**
     * Создание файла.
     *
     * @param object Объект
     */
    public VariantFile(File object) {
        super(object);
    }

    /**
     * Создание файла.
     *
     * @param parentPath Родительский путь
     * @param childPath  Путь к дочернему объекту
     */
    public VariantFile(String parentPath, String childPath) {
        super(parentPath, childPath);
    }

    /**
     * Создание файла.
     *
     * @param path Путь
     */
    public VariantFile(String path) {
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
    public VariantFile setCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

    @Override
    protected Variant readUnsafe() throws IOException {
        return Variant.fromJsonString(FileUtils.readFileToString(location, charset));
    }

    @Override
    protected void writeUnsafe(Variant content) throws IOException {
        FileUtils.writeStringToFile(location, content.toJsonString(), charset);
    }
}
