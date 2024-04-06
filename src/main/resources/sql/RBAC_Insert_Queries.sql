
INSERT INTO roles (role_name, description)
VALUES 
    ('Admin', 'Has complete control over all features'),
    ('Supervisor', 'Can grant read/write privileges'),
    ('Worker', 'Has read privileges'),
    ('ReadWriteUser', 'Has read and write privileges'),
    ('ReadDeleteUser', 'Has read and delete privileges');





INSERT INTO permissions (permission_name, description)
VALUES 
    ('Read Users', 'Allows reading user information'),
    ('Create Users', 'Allows creating new users'),
    ('Update Users', 'Allows updating existing users'),
    ('Delete Users', 'Allows deleting users'),
    ('Grant Role Users', 'Allows granting roles to users');




INSERT INTO users (username, password, first_name, last_name, birth_date, role_id)
VALUES 
    ('admin', 'admin', 'Gourav', 'Agarwal', '1990-05-15', 1), -- Admin
    ('supervisor', 'supervisor', 'Jane', 'Smith', '1985-09-20', 2), -- Supervisor
    ('worker', 'worker', 'Bob', 'Jones', '1995-03-10', 3); -- Worker





-- Admin role has all permissions
INSERT INTO role_permissions (role_id, permission_id)
SELECT role_id, permission_id FROM roles, permissions WHERE role_name = 'Admin';

-- Supervisor role has read users and grant read/write access permissions
INSERT INTO role_permissions (role_id, permission_id)
SELECT role_id, permission_id FROM roles, permissions WHERE role_name = 'Supervisor' 
AND (permission_name = 'Read Users' OR permission_name = 'Grant Role Users');


-- Worker role has read users permission
INSERT INTO role_permissions (role_id, permission_id)
SELECT role_id, permission_id FROM roles, permissions WHERE role_name = 'Worker' 
AND permission_name = 'Read Users';


-- ReadWriteUser role has read and write permissions
INSERT INTO role_permissions (role_id, permission_id)
SELECT role_id, permission_id FROM roles, permissions WHERE role_name = 'ReadWriteUser' 
AND (permission_name = 'Read Users' OR permission_name = 'Update Users');

-- ReadDeleteUser role has read and delete permissions
INSERT INTO role_permissions (role_id, permission_id)
SELECT role_id, permission_id FROM roles, permissions WHERE role_name = 'ReadDeleteUser' 
AND (permission_name = 'Read Users' OR permission_name = 'Delete Users');




