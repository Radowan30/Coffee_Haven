INSERT INTO `role` (`id`, `name`) VALUES
                                      (2, 'ROLE_ADMIN'),
                                      (1, 'ROLE_USER');

INSERT INTO `product` (`id`, `description`, `imageurl`, `name`, `origin`, `price`, `stock`, `type`) VALUES
                                                                                                        (2, 'Ethiopian Yirgacheffe beans are celebrated for their bright acidity and floral notes, often accompanied by hints of citrus and berries. Grown at high elevations, these beans produce a clean and aromatic cup, making them a favorite among specialty coffee e', '/images/coffee-3392168_1280.jpg', 'Ethiopian Yirgacheffe', 'Yirgacheffe, Ethiopia', 18, 12, NULL),
                                                                                                        (4, 'Colombian Supremo beans are characterized by their balanced flavor profile, medium body, and bright acidity. With notes of caramel and nuts, these beans offer a smooth and satisfying cup, reflecting Colombia\'s rich coffee-growing heritage.', '/images/coffee-1576552_1280.jpg', 'Colombian Supremo', 'Colombia', 15, 10, NULL),
(5, 'Grown in the Antigua region, these beans are renowned for their full body and rich flavor, featuring notes of cocoa, spice, and a subtle smokiness. The volcanic soil and ideal climate conditions contribute to the coffee\'s distinctive profile.', '/images/coffee-1576552_1280.jpg', 'Guatemala Antigua', 'Antigua, Guatemala', 17, 10, NULL),
                                                                                                        (6, 'Kenya AA beans are distinguished by their bright acidity and complex flavor profile, with notes of blackcurrant, citrus, and a wine-like finish. The \'AA\' grade signifies the highest quality beans, known for their large size and superior flavor.', '/images/coffee-1576552_1280.jpg', 'Kenya AA', 'Kenya', 19, 10, NULL),
                                                                                                        (7, 'Sumatra Mandheling beans are known for their full body and low acidity, with flavor notes of chocolate, earthy undertones, and a hint of spice. The unique wet-hulling process used in Sumatra imparts a rich, syrupy mouthfeel, making it a popular choice for', '/images/coffee-beans-6603499_1280.jpg', 'Sumatra Mandheling', 'Sumatra, Indonesia', 16, 5, NULL);



INSERT INTO `orders` (`id`, `customer`, `date`, `status`, `total`, `user_id`) VALUES
                                                                                  (1, 'Ahmed', '2025-01-01 10:06:53.000000', 'Delivered', 10, 1),
                                                                                  (2, 'Radowan', '2025-01-02 10:14:03.000000', 'Processing', 5, 1);
