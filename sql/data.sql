USE warehouse;

-- ===============================
-- Categories
-- ===============================
INSERT INTO categories (name, description) VALUES
('Electronics', 'Electronic devices and accessories'),
('Furniture', 'Office and home furniture'),
('Food', 'Food and beverages');

-- ===============================
-- Suppliers
-- ===============================
INSERT INTO suppliers (name, email, phone) VALUES
('TechSupplier GmbH', 'contact@techsupplier.de', '+49 30 123456'),
('OfficeWorld AG', 'info@officeworld.de', '+49 40 654321'),
('FoodTrade GmbH', 'sales@foodtrade.de', '+49 89 987654');

-- ===============================
-- Products
-- ===============================
INSERT INTO products (
    sku, name, category_id, supplier_id, price, quantity, min_quantity, active
) VALUES
('SSD-1TB', 'SSD Drive 1TB', 1, 1, 99.99, 50, 10, TRUE),
('OFFICE-CHAIR', 'Office Chair', 2, 2, 149.90, 20, 5, TRUE),
('COFFEE-1KG', 'Coffee Beans 1kg', 3, 3, 12.50, 100, 20, TRUE);

-- ===============================
-- Stock Movements
-- ===============================
INSERT INTO stock_movements (
    product_id, type, quantity, reference
) VALUES
(1, 'IN', 50, 'Initial stock'),
(2, 'IN', 20, 'Initial stock'),
(3, 'IN', 100, 'Initial stock'),

(1, 'OUT', 5, 'Order #1001'),
(3, 'OUT', 10, 'Order #1002');
